import IA.DistFS.Servers;
import codes.*;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

public class DFADemo {

    static float execTimeAverage1;

    public static void main(String[] args) throws Servers.WrongParametersException {
        DFSBoard board = new DFSBoard(50, 5, 200, 5, 1);
        int[] iteracions = {100000};
        int[] intersPcanvi = {5000, 10000, 20000};
        int[] ks = {5, 25, 125, 625, 3125, 5000};
        double[] lamb = {0.1, 0.01, 0.001, 0.0001, 0.0000001};
        for (int i : iteracions) {
            for (int j : intersPcanvi) {
                for (int k : ks) {
                    for (double l : lamb) {
                        System.out.println(i + "\n" + j + "\n" + k + "\n" + l + "\n");
                        DFSSimulatedAnnealingSearch1(board, i, j, k, l);
                    }
                }
            }
        }
    }

    private static void DFSHillClimbingSearch1(DFSBoard board) {
        //System.out.println("\nDFA HillClimbing  -->");
        try {
            long startTime = System.nanoTime();
            Problem problem =  new Problem(board,new DFSSuccessorFunction(), new DFSGoalTest(),new DFSHeuristicFunctionCriteri1());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            long endTime = System.nanoTime();
            //System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            //System.out.println();
            execTimeAverage1 += (float) (endTime - startTime) / 1000000.0f;
            //printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            DFSHeuristicFunctionCriteri1 h = new DFSHeuristicFunctionCriteri1();
            System.out.println("El valor de la heurística per a la solució final és: " + h.getHeuristicValue(boardFinal));
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void DFSHillClimbingSearch2(DFSBoard board) {
        //System.out.println("\nDFA HillClimbing  -->");
        try {
            long startTime = System.nanoTime();
            Problem problem =  new Problem(board,new DFSSuccessorFunction(), new DFSGoalTest(),new DFSHeuristicFunctionCriteri21());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            long endTime = System.nanoTime();
            System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            System.out.println();
            //printActions(agent.getActions());
            //printInstrumentation(agent.getInstrumentation());

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            DFSHeuristicFunction2 h = new DFSHeuristicFunction2();
            System.out.println("El valor de la heurística per a la solució final és: " + h.getHeuristicValue(boardFinal));
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void DFSSimulatedAnnealingSearch1(DFSBoard board, int iterations, int iterationsPerTempChange, int k, double lambda) {
        //System.out.println("\nDFA Simulated Annealing -->");
        double heuristicValue = Double.MAX_VALUE;
        try {
            long startTime = System.nanoTime();
            Problem problem = new Problem(board, new DFSSuccessorFunctionSA(), new DFSGoalTest(), new DFSHeuristicFunctionCriteri1());
            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(iterations, iterationsPerTempChange, k, lambda);
            SearchAgent agent = new SearchAgent(problem, search);

            long endTime = System.nanoTime();
            System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            System.out.println();
            execTimeAverage1 += (float) (endTime - startTime) / 1000000.0f;
            // printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            DFSHeuristicFunctionCriteri1 h = new DFSHeuristicFunctionCriteri1();
            heuristicValue = h.getHeuristicValue(boardFinal);
            System.out.println("El valor de la heurística per a la solució final és: " + heuristicValue);
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void DFSSimulatedAnnealingSearch2(DFSBoard board, int iterations, int iterationsPerTempChange, int k, double lambda) {
        //System.out.println("\nDFA Simulated Annealing -->");
        double heuristicValue = Double.MAX_VALUE;
        try {
            long startTime = System.nanoTime();
            Problem problem = new Problem(board, new DFSSuccessorFunction(), new DFSGoalTest(), new DFSHeuristicFunction2());
            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(iterations, iterationsPerTempChange, k, lambda);
            SearchAgent agent = new SearchAgent(problem, search);

            long endTime = System.nanoTime();
            System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            System.out.println();
            // printActions(agent.getActions());
            //printInstrumentation(agent.getInstrumentation());

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            DFSHeuristicFunction2 h = new DFSHeuristicFunction2();
            heuristicValue = h.getHeuristicValue(boardFinal);
            System.out.println("El valor de la heurística per a la solució final és: " + heuristicValue);
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }
        
    }
    
    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i);
            System.out.println(action);
        }
    }
    
}
