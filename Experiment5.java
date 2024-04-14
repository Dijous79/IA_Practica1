import IA.DistFS.Servers;
import aima.search.framework.*;
import codes.*;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;

import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

public class Experiment5 {

    public static void main(String[] args) throws Servers.WrongParametersException {
        /*double [][] a = new double[200][5];
        for(int i =0; i< 100; i++){

            DFSBoard board = new DFSBoard(50, 5, 200, 5, 1234+i);
            DFSHillClimbingSearch(board, new DFSSuccessorFunction(),a,i);
            double [][] b = new double[5][5];
            for(int j = 0; j< 5; j++) {
                DFSBoard board2 = new DFSBoard(50, 5, 200, 5, 1234+i,j+i);
                DFSHillClimbingSearch(board2, new DFSSuccessorFunction(), b, j);
            }
            for(int j = 0; j< 5; j++) {
                for(int k = 0; k< 5; k++){
                    a[i+100][j] += b[k][j];
                }
                a[i+100][j] = a[i+100][j]/5;
            }

        }
        System.out.println("Resultats: Temps        Heuristica         Temps total     Temps max    Nodes Visit");
        for(int i =0; i< 200; i++){
            System.out.println(a[i][0] + " " + a[i][1] + " " + a[i][2] + " " + a[i][3]+ " " + a[i][4]);
        }

        System.out.println();
    */
        double [][] a = new double[20][5];
        for(int i =0; i< 5; i++){
            DFSBoard board = new DFSBoard(50, 5, 200, 5, 1234+i,i);
            DFSSimulatedAnnealingSearch(board, new DFSHeuristicFunctionCriteri21(),a,i);
            DFSSimulatedAnnealingSearch(board, new DFSHeuristicFunctionCriteri23(),a,i+10);
        }

        System.out.println("Resultats: Temps        Heuristica         Temps total     Temps max    Nodes Visit");
        for(int i =0; i< 20; i++){
            System.out.println(a[i][0] + " " + a[i][1] + " " + a[i][2] + " " + a[i][3]+ " " + a[i][4]);
        }

        System.out.println();

        /* Define arrays for parameter values
        int[] iterationsValues = {100000};
        int[] iterationsPerTemperatureChangeValues = {500, 1000, 10000};
        int[] kValues = {5,50,500,5000,50000};
        double[] lambdaValues = {0.01, 0.0001,0.00001 , 0.000001, 0.0000001};
        DFSBoard board = new DFSBoard(50, 5, 200, 5, 1234);
        // Nested loops to iterate over all parameter combinations
        for (int iterations : iterationsValues) {
            for (int iterationsPerTempChange : iterationsPerTemperatureChangeValues) {
                for (int k : kValues) {
                    for (double lambda : lambdaValues) {
                        // Execute DFSSimulatedAnnealingSearch with current parameter values
                        System.out.println("Iterations: " + iterations);
                        System.out.println("IterationsPerTempChange: " + iterationsPerTempChange);
                        System.out.println("K: " + k);
                        System.out.println("Lambda: " + lambda);

                        DFSSimulatedAnnealingSearch(board, iterations, iterationsPerTempChange, k, lambda);

                    }
                }
            }
        }
         */

    }

    private static void DFSHillClimbingSearch(DFSBoard board, SuccessorFunction s, HeuristicFunction h, double [][] a, int i) {
        System.out.println("\nDFA HillClimbing  -->");
        try {
            long startTime = System.nanoTime();
            Problem problem =  new Problem(board,s, new DFSGoalTest(),h);
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            long endTime = System.nanoTime();
            System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            a[i][0] = (endTime - startTime) / 1000000;
            System.out.println();
            //printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation(),a,i);

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            System.out.println("El valor de la heurística per a la solució final és: " + h.getHeuristicValue(boardFinal));
            a[i][1]= h.getHeuristicValue(boardFinal);
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");
            a[i][2] = boardFinal.getTemosTotal();
            a[i][3] = m;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void DFSSimulatedAnnealingSearch(DFSBoard board, HeuristicFunction hs, double[][] a, int i) {
        System.out.println("\nDFA Simulated Annealing -->");
        double heuristicValue = Double.MAX_VALUE;
        try {
            long startTime = System.nanoTime();
            Problem problem = new Problem(board, new DFSSuccessorFunction(), new DFSGoalTest(), hs);
            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(50000, 100, 500, 0.01);
            SearchAgent agent = new SearchAgent(problem, search);

            long endTime = System.nanoTime();
            System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            a[i][0] = (endTime - startTime) / 1000000;
            System.out.println();

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            DFSHeuristicFunctionCriteri1 h = new DFSHeuristicFunctionCriteri1();
            heuristicValue = h.getHeuristicValue(boardFinal);
            System.out.println("El valor de la heurística per a la solució final és: " + heuristicValue);
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");
            a[i][1]= h.getHeuristicValue(boardFinal);
            a[i][2] = boardFinal.getTemosTotal();
            a[i][3] = m;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printInstrumentation(Properties properties, double [][] a, int i) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
            a[i][4] = Double.parseDouble(property);
        }

    }

    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i);
            System.out.println(action);
        }
    }

}