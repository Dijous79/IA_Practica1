package codes;

import IA.DistFS.*;
import aima.util.Pair;

import java.util.*;

public class DFSBoard {
    public static Servers servers;
    public static Requests requests;
    private Set<Pair>[] assignacio;
    private int[] tempsServers;
    private int nServers;
    public DFSBoard(int nServers, int mReps, int nUsers, int mConsults, int seed) throws Servers.WrongParametersException {
        this.nServers = nServers;
        servers = new Servers(nServers, mReps, seed);
        requests = new Requests(nUsers, mConsults, seed);
        tempsServers = new int[nServers];

        Random myRandom = new Random();
        myRandom.setSeed(seed);
        assignacio = creaAssignacio(nServers, myRandom);

    }
    public DFSBoard(DFSBoard db) {
        this.assignacio = new HashSet[db.assignacio.length];
        for (int i = 0; i < db.assignacio.length; i++) {
            this.assignacio[i] = new HashSet<>(db.assignacio[i]);
        }
        this.tempsServers = Arrays.copyOf(db.tempsServers, db.tempsServers.length);
        this.nServers = db.nServers;
    }


    private Set<Pair>[] creaAssignacio(int nS, Random rand) {
        Set<Pair>[] res = new HashSet[nS];
        for (int i = 0; i < nS; i++) { // Initialize each element of res
            res[i] = new HashSet<>();
        }
        for(int i = 0; i < requests.size(); ++i) {
            int[] aux = requests.getRequest(i);
            Pair elem = new Pair(aux[0], aux[1]);
            Set<Integer> servs = servers.fileLocations((Integer) elem.getSecond());
            int rn = rand.nextInt(servs.size());
            Integer[] servs2array = servs.toArray(new Integer[servs.size()]);
            res[servs2array[rn]].add(elem);
            tempsServers[servs2array[rn]] += servers.tranmissionTime(servs2array[rn], (int) elem.getFirst());
        }
        return res;
    }


    public void pintaConsultes() {
        for (int i = 0; i < assignacio.length; ++i) {
            System.out.println("Servidor " + i + " -> " + assignacio[i]);
        }
        System.out.println(Arrays.toString(tempsServers));
    }

    public int getNServers() {
        return nServers;
    }

    public int getServerTime(int i) {
        return tempsServers[i];
    }

    public Set<Pair>[] getAssignacio() {
        return assignacio;
    }
    
    public Set<Pair> getServerQueries(int serv) { return assignacio[serv]; }

    public void moveQuery(int origen, Pair uf, int dest) {
        assignacio[origen].remove(uf);
        tempsServers[origen] -= servers.tranmissionTime(origen, (Integer) uf.getFirst());
        assignacio[dest].add(uf);
        tempsServers[dest] += servers.tranmissionTime(dest, (Integer) uf.getFirst());
    }

    public Set<Integer> Servers2Transmit(int n) {
        return servers.fileLocations(n);
    }
}