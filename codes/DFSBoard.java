package codes;

import IA.DistFS.*;

import java.util.*;

public class DFSBoard {
    private static Servers servers;
    private static Requests requests;
    private int[] assignacio;
    private int[] tempsServers;
    private int nServers;
    public DFSBoard(int nServers, int mReps, int nUsers, int mConsults, int seed) throws Servers.WrongParametersException {
        this.nServers = nServers;
        servers = new Servers(nServers, mReps, seed);
        requests = new Requests(nUsers, mConsults, seed);
        tempsServers = new int[nServers];
        assignacio = new int[requests.size()];
        creaAssignacioGreedy(nUsers);
    }
    public DFSBoard(int nServers, int mReps, int nUsers, int mConsults, int seed, int seedDistribucio) throws Servers.WrongParametersException {
        this.nServers = nServers;
        servers = new Servers(nServers, mReps, seed);
        requests = new Requests(nUsers, mConsults, seed);
        tempsServers = new int[nServers];
        assignacio = new int[requests.size()];
        Random myRandom = new Random();
        myRandom.setSeed(seedDistribucio);
        creaAssignacioRand(nUsers, myRandom);
    }
    public DFSBoard(DFSBoard db) {
        this.assignacio = Arrays.copyOf(db.assignacio, db.assignacio.length);
        this.tempsServers = Arrays.copyOf(db.tempsServers, db.tempsServers.length);
        this.nServers = db.nServers;
    }


    private void creaAssignacioRand(int nU, Random rand) {
        Arrays.fill(tempsServers, 0);
        for(int i = 0; i < requests.size(); ++i) {
            int[] aux = requests.getRequest(i);
            Set<Integer> servs = servers.fileLocations(aux[1]);
            int rn = rand.nextInt(servs.size());
            Integer[] servs2array = servs.toArray(new Integer[servs.size()]);
            assignacio[i] = servs2array[rn];
            tempsServers[servs2array[rn]] += servers.tranmissionTime(servs2array[rn], aux[0]);
        }
    }

    private void creaAssignacioGreedy(int nU) {
        Arrays.fill(tempsServers, 0);
        for(int i = 0; i < requests.size(); ++i) {
            int[] aux = requests.getRequest(i);
            Set<Integer> servs = servers.fileLocations(aux[1]);
            int min = Integer.MAX_VALUE;
            int minServ = -1;
            for (Integer s : servs) {
                if (tempsServers[s] < min) {
                    min = tempsServers[s];
                    minServ = s;
                }
            }
            assignacio[i] = minServ;
            tempsServers[minServ] += servers.tranmissionTime(minServ, aux[0]);
        }
    }


    public void pintaConsultes() {
        //int s= 0;
        for (int i = 0; i < assignacio.length; ++i) {
            System.out.println("Consulta: " + Arrays.toString(requests.getRequest(i)) + " Es fa al servidor -> " + assignacio[i]);
        }
        System.out.println("Temps final de cada servidor: " + Arrays.toString(tempsServers));
    }

    public String stringTime() {
        return Arrays.toString(tempsServers);
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

    public int[] getConsulta(int n) { return requests.getRequest(n); }
    public Integer[] getServers4Fitxers(int f) {
        Set<Integer> servs = servers.fileLocations(f);
        return servs.toArray(new Integer[0]);
    }

    public Set<Integer> getSet(int f){
        return servers.fileLocations(f);
    }

    public void moveQuery(int pairPos, int server) {
        int origen = assignacio[pairPos];
        assignacio[pairPos] = server;
        tempsServers[origen] -= servers.tranmissionTime(origen, requests.getRequest(pairPos)[0]);
        tempsServers[server] += servers.tranmissionTime(server, requests.getRequest(pairPos)[0]);
    }

    public void  swap(int i, int j) {
        int aux = assignacio[i];
        assignacio[i] = assignacio[j];
        assignacio[j] = aux;
        tempsServers[aux] -= servers.tranmissionTime(aux, requests.getRequest(i)[0]);
        tempsServers[assignacio[i]] -= servers.tranmissionTime(assignacio[i], requests.getRequest(j)[0]);
        tempsServers[assignacio[i]] += servers.tranmissionTime(assignacio[i], requests.getRequest(i)[0]);
        tempsServers[aux] += servers.tranmissionTime(aux, requests.getRequest(j)[0]);

    }

    public Set<Integer> Servers2Transmit(int n) {
        return servers.fileLocations(n);
    }

    public  int getTemosTotal() {
        int sum = 0;
        for (int n : tempsServers) {
            sum += n;
        }
        return sum;
    }
    public  int getTempsMax() {
        int m = 0;
        for (int n:tempsServers) {
            if (n > m)
                m = n;
        }
        return m;
    }
}