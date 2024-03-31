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

    public static void main(String[] args) throws Servers.WrongParametersException {
        DFSBoard board = new DFSBoard(50, 5, 200, 5, 1234);
        DFSHillClimbingSearch(board);
        //DFSSimulatedAnnealingSearch(board);
    }

    private static void DFSHillClimbingSearch(DFSBoard board) {
        System.out.println("\nDFA HillClimbing  -->");
        try {
            Problem problem =  new Problem(board,new DFSSuccessorFunction(), new DFSGoalTest(),new DFSHeuristicFunction());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);
            
            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
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
