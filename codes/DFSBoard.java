package codes;

import IA.DistFS.*;
import aima.util.Pair;

import java.util.Random;
import java.util.Set;
import java.util.Vector;

public class DFSBoard {
    static Servers servers;
    static Requests requests;
    Vector<Pair>[] assignacio;
    int[] tempsServers;
    public DFSBoard(int nServers, int mReps, int nUsers, int mConsults, int seed) throws Servers.WrongParametersException {
        servers = new Servers(nServers, mReps, seed);
        requests = new Requests(nUsers, mConsults, seed);
        tempsServers = new int[nServers];

        Random myRandom = new Random();
        myRandom.setSeed(seed);
        assignacio = creaAssignacio(nUsers, myRandom);

    }
    public DFSBoard(DFSBoard db) {
        assignacio = db.assignacio;
    }

    private Vector<Pair>[] creaAssignacio(int nU, Random rand) {
        Vector<Pair>[] res = new Vector[nU];
        for(int i = 0; i < requests.size(); ++i) {
            int[] aux = requests.getRequest(i);
            Pair elem = new Pair(aux[0], aux[1]);
            Set<Integer> servs = servers.fileLocations((Integer) elem.getSecond());
            int rn = rand.nextInt() % servs.size();
            Integer[] servs2array = (Integer[]) servs.toArray();
            res[servs2array[rn]].add(elem);
            tempsServers[servs2array[rn]] += servers.tranmissionTime(servs2array[rn], (int) elem.getFirst());
        }
        return res;
    }
}
