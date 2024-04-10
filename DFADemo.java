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

    public static void main(String[] args) throws Servers.WrongParametersException {
        DFSBoard board = new DFSBoard(50, 5, 200, 5, 1234);
        // Define arrays for parameter values
        int[] iterationsValues = {5000};
        int[] iterationsPerTemperatureChangeValues = {200, 500, 1000};
        int[] kValues = {5, 25, 100, 500, 2000};
        double[] lambdaValues = {0.01, 0.001, 0.0001, 0.00001};

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

    }

    private static void DFSHillClimbingSearch(DFSBoard board) {
        System.out.println("\nDFA HillClimbing  -->");
        try {
            long startTime = System.nanoTime();
            Problem problem =  new Problem(board,new DFSSuccessorFunction(), new DFSGoalTest(),new DFSHeuristicFunction2());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            long endTime = System.nanoTime();
            System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            System.out.println();
            //printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            DFSHeuristicFunction2 h = new DFSHeuristicFunction2();
            System.out.println("El valor de la heurística per a la solució final és: " + h.getHeuristicValue(boardFinal));
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void DFSSimulatedAnnealingSearch(DFSBoard board, int iterations, int iterationsPerTempChange, int k, double lambda) {
        System.out.println("\nDFA Simulated Annealing -->");
        double heuristicValue = Double.MAX_VALUE;
        try {
            Problem problem = new Problem(board, new DFSSuccessorFunction(), new DFSGoalTest(), new DFSHeuristicFunction2());
            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(iterations, iterationsPerTempChange, k, lambda);
            SearchAgent agent = new SearchAgent(problem, search);

            System.out.println();
            // printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());

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
