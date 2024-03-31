package codes;

import java.util.*;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import aima.util.Pair;

public class DFSSuccessorFunction implements SuccessorFunction {

    public List<Successor> getSuccessors(Object state) {
        DFSBoard board = (DFSBoard) state;
        List<Successor> ret = new ArrayList<>();

        for (int i = 0; i < board.getAssignacio().length; ++i) {
            int[] act = board.getConsulta(i);
            Integer[] servs = board.getServers4Fitxers(act[1]);
            for (Integer s : servs) {
                DFSBoard nextSuccesor = new DFSBoard(board);
                nextSuccesor.moveQuery(i, s);
                String nom = Arrays.toString(act) + " -> " + s.toString();
                ret.add(new Successor(nom, nextSuccesor));
            }
        }

        return ret;
    }

}