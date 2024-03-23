package codes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import aima.util.Pair;

public class DFSSuccessorFunction implements SuccessorFunction {

    public List<Successor> getSuccessors(Object state) {
        DFSBoard board = (DFSBoard) state;
        List<Successor> ret = new ArrayList<>();

        for (int i = 0; i < board.getAssignacio().length; ++i) {

            Set<Pair> queries = new HashSet<>(board.getServerQueries(i)); // Create a copy of the set
            for (Pair uf : queries) {
                Set<Integer> servs = board.Servers2Transmit((Integer) uf.getSecond());
                for (Integer n : servs) {
                    //System.out.println(uf + " -> " + n);
                    if (n != i) {
                        DFSBoard newSuccessor = new DFSBoard(board);
                        newSuccessor.moveQuery(i, uf, n);
                        String s = uf + " -> " + n;
                        ret.add(new Successor(s, newSuccessor));
                    }
                }
            }
        }
        //System.out.println(ret.size());
        /*for(DFSBoard b : ret) {
            b.pintaConsultes();
        }*/

        //System.out.println("un cop");
        return ret;
    }

}