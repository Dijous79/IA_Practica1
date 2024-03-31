package codes;

import IA.DistFS.*;
import aima.util.Pair;

import java.util.*;

public class DFSBoard {
    private static Servers servers;
    private static Requests requests;
    private int[] assignacio;
    private int[] tempsServers;
    private static Pair[] dataUsersFitxers;
    private int nServers;
    public DFSBoard(int nServers, int mReps, int nUsers, int mConsults, int seed) throws Servers.WrongParametersException {
        this.nServers = nServers;
        servers = new Servers(nServers, mReps, seed);
        requests = new Requests(nUsers, mConsults, seed);
        tempsServers = new int[nServers];
        dataUsersFitxers = new Pair[requests.size()];
        assignacio = new int[requests.size()];

        Random myRandom = new Random();
        myRandom.setSeed(seed);
        creaAssignacio(nUsers, myRandom);
    }
    public DFSBoard(DFSBoard db) {
        this.assignacio = Arrays.copyOf(db.assignacio, db.assignacio.length);
        this.tempsServers = Arrays.copyOf(db.tempsServers, db.tempsServers.length);
        this.nServers = db.nServers;
    }


    private void creaAssignacio(int nU, Random rand) {
        Arrays.fill(tempsServers, 0);
        for(int i = 0; i < requests.size(); ++i) {
            int[] aux = requests.getRequest(i);
            Pair elem = new Pair(aux[0], aux[1]);
            dataUsersFitxers[i] = elem;
            Set<Integer> servs = servers.fileLocations((Integer) elem.getSecond());
            int rn = rand.nextInt(servs.size());
            Integer[] servs2array = servs.toArray(new Integer[servs.size()]);
            assignacio[i] = servs2array[rn];
            tempsServers[servs2array[rn]] += servers.tranmissionTime(servs2array[rn], (int) elem.getFirst());
        }
    }


    public void pintaConsultes() {
        //int s= 0;
        for (int i = 0; i < assignacio.length; ++i) {
            System.out.println("Consulta: " + dataUsersFitxers[i] + " Es fa al servidor -> " + assignacio[i]);
        }
        System.out.println(Arrays.toString(tempsServers));
    }

    public int getNServers() {
        return nServers;
    }

    public int getServerTime(int i) {
        return tempsServers[i];
    }

    public int[] getAssignacio() {
        return assignacio;
    }
    
    public Pair[] getDataUsersFitxers(int serv) { return dataUsersFitxers; }
    public Pair getConsulta(int n) { return dataUsersFitxers[n]; }
    public Integer[] getServers4Fitxers(int f) {
        Set<Integer> servs = servers.fileLocations(f);
        return servs.toArray(new Integer[0]);
    }

    public void moveQuery(int pairPos, int server) {
        int origen = assignacio[pairPos];
        assignacio[pairPos] = server;
        tempsServers[origen] -= servers.tranmissionTime(origen, (Integer) dataUsersFitxers[pairPos].getFirst());
        tempsServers[server] += servers.tranmissionTime(server, (Integer) dataUsersFitxers[pairPos].getFirst());
    }

    public Set<Integer> Servers2Transmit(int n) {
        return servers.fileLocations(n);
    }
}