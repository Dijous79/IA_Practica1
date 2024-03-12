package codes;

import IA.DistFS.*;

import java.util.Arrays;

public class DFSBoard {
    Servers servers;
    Requests requests;
    int[][] assignacio;
    public DFSBoard(int nServers, int mReps, int nUsers, int mConsults, int seed) throws Servers.WrongParametersException {
        servers = new Servers(nServers, mReps, seed);
        requests = new Requests(nUsers, mConsults, seed);
        assignacio = new int[nUsers][mConsults];
        assignacioInicial();
    }
    private void assignacioInicial() {
        for (int[] is : assignacio) Arrays.fill(is, 0);
    }
}
