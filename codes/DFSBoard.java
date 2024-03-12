package codes;

import IA.DistFS.*;

import java.util.Arrays;
import java.util.Random;

public class DFSBoard {
    Servers servers;
    Requests requests;
    int[][] assignacio;
    public DFSBoard(int nServers, int mReps, int nUsers, int mConsults, int seed) throws Servers.WrongParametersException {
        servers = new Servers(nServers, mReps, seed);
        requests = new Requests(nUsers, mConsults, seed);
        assignacio = new int[nUsers][mConsults];
        
        Random myRandom = new Random();
        myRandom.setSeed(seed);
        
        assignacioInicial(myRandom);
    }
    private void assignacioInicial(Random myRandom) {
        //hem de fer que entre les assignacions valides que fagi random.
        //for (int[] is : assignacio) Arrays.fill(is, 0);
    }
}
