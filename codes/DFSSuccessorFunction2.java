package codes;

import java.util.*;

import IA.TSP2.ProbTSPHeuristicFunction;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import aima.util.Pair;

public class DFSSuccessorFunction2 implements SuccessorFunction {

    public List<Successor> getSuccessors(Object state) {
        DFSBoard board = (DFSBoard) state;
        List<Successor> ret = new ArrayList<>();
        DFSHeuristicFunctionCriteri1 heuristica  = new DFSHeuristicFunctionCriteri1();

        for (int i = 0; i < board.getAssignacio().length; ++i) {
            int[] act = board.getConsulta(i);
            Integer[] servs = board.getServers4Fitxers(act[1]);
            for (Integer s : servs) {
                DFSBoard nextSuccesor = new DFSBoard(board);
                nextSuccesor.moveQuery(i, s);
                double v = heuristica.getHeuristicValue(nextSuccesor);
                String nom = Arrays.toString(act) + " -> " + s.toString() + " Coste(" + v + ") ---> " + nextSuccesor.stringTime();
                ret.add(new Successor(nom, nextSuccesor));
            }
        }
        int[] assig = board.getAssignacio();
        for (int i = 0; i < assig.length-1; ++i) {
            for (int j=i+1; j< assig.length; ++j) {
                int[] acti = board.getConsulta(i);
                int[] actj = board.getConsulta(j);
                Set<Integer> servsi = board.getSet(acti[1]);
                Set<Integer> servsj = board.getSet(actj[1]);
                if(servsi.contains(assig[j]) && servsj.contains(assig[i])) {
                    DFSBoard nextSuccesor = new DFSBoard(board);
                    nextSuccesor.swap(i, j);
                    double v = heuristica.getHeuristicValue(nextSuccesor);
                    String nom = Arrays.toString(acti) + " -> " + Arrays.toString(actj) + " Coste(" + v + ") ---> " + nextSuccesor.stringTime();
                    ret.add(new Successor(nom, nextSuccesor));
                    //System.out.println(nom);
                }
            }
        }
        //System.out.println(ret.size());
        return ret;
    }

}