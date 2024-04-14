package codes;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import codes.DFSBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DFSSuccessorFunctionSA implements SuccessorFunction {

    public List<Successor> getSuccessors(Object state) {
        DFSBoard board = (DFSBoard) state;
        List<Successor> ret = new ArrayList<>();

        Random myRand = new Random();

        int i = myRand.nextInt(board.getAssignacio().length);
            int[] act = board.getConsulta(i);
            Integer[] servs = board.getServers4Fitxers(act[1]);
            int s = myRand.nextInt(servs.length);
            DFSBoard nextSuccesor = new DFSBoard(board);
            nextSuccesor.moveQuery(i, s);
            ret.add(new Successor("", nextSuccesor));

        return ret;
    }

}