import IA.DistFS.Servers;
import codes.*;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

public class DFADemo {

    private static int millorMaxim;
    public static void main(String[] args) throws Servers.WrongParametersException {
        millorMaxim = Integer.MAX_VALUE;
        System.out.println("Distribució inicial Random");
       for (int i = 0; i < 100; ++i) {
            DFSBoard board = new DFSBoard(50, 5, 200, 5, 1234, i);
            System.out.println("//////" + i + "//////");
            DFSHillClimbingSearch(board);
        }
        System.out.println(millorMaxim);
        System.out.println("Distribució inicial Greedy");
        DFSBoard board2 = new DFSBoard(50, 5, 200, 5, 1234);
        DFSHillClimbingSearch(board2);
        //DFSSimulatedAnnealingSearch(board);
    }

    private static void DFSHillClimbingSearch(DFSBoard board) {
        System.out.println("\nDFA HillClimbing  -->");
        try {
            long startTime = System.nanoTime();
            Problem problem =  new Problem(board,new DFSSuccessorFunction(), new DFSGoalTest(),new DFSHeuristicFunctionCriteri1());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            long endTime = System.nanoTime();
            System.out.println();
            System.out.println("Time: " + (endTime - startTime) / 1000000 + "ms");
            System.out.println();
            //printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());

            DFSBoard boardFinal = (DFSBoard) search.getGoalState();
            DFSHeuristicFunctionCriteri1 h = new DFSHeuristicFunctionCriteri1();
            System.out.println("El valor de la heurística per a la solució final és: " + h.getHeuristicValue(boardFinal));
            int m = boardFinal.getTempsMax();
            System.out.println("El temps de transmisió total és: " + boardFinal.getTemosTotal() + " i el temps màxim és: " + m + "\n");
            //if (millorMaxim > m)
                //millorMaxim = m;
            boardFinal.pintaConsultes();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void DFSSimulatedAnnealingSearch(DFSBoard board) {
        System.out.println("\nDFA Simulated Annealing  -->");
        try {
            Problem problem =  new Problem(board,new DFSSuccessorFunction(), new DFSGoalTest(),new DFSHeuristicFunction());
            SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(2000,100,5,0.001);
            //search.traceOn();
            SearchAgent agent = new SearchAgent(problem,search);
            
            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
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
