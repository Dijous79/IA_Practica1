package codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import aima.util.Pair;

public class DFSSuccessorFunction implements SuccessorFunction {

    public List getSuccessors(Object state) {
        DFSBoard board = (DFSBoard) state;
        List<DFSBoard> ret = new ArrayList<>();

        for(Set<Pair> Queries : board.assignacio) {
            for (Pair uf : Queries) {

            }
        }

        return ret;
    }
}
