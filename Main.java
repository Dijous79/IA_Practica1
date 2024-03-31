import IA.DistFS.Servers;
import codes.DFSBoard;
import codes.DFSHeuristicFunction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Servers.WrongParametersException {
        /*
        int nS, nU, mR, mC, s;
        Scanner scn = new Scanner(System.in);
        System.out.println("input: nº of Servers:");
        nS = scn.nextInt();
        System.out.println("input: nº of Users:");
        nU = scn.nextInt();
        System.out.println("input: nº of minimumRepeated files:");
        mR = scn.nextInt();
        System.out.println("input: nº of maximumRequests for user:");
        mC = scn.nextInt();
        System.out.println("input: random seed:");
        s = scn.nextInt();

        DFSBoard prova = new DFSBoard(nS, mR, nU, mC, s);
        */
        
        double minValue = Double.MAX_VALUE;
        double maxValue = Double.MIN_VALUE;
        int minI = 0;
        int maxI = 0;
        DFSBoard minBoard = null;
        DFSBoard maxBoard = null;
        
        for (int i = 1; i <= 10000; i++) {
            DFSBoard board = new DFSBoard(6, 2, 12, 3, i,1);
            DFSHeuristicFunction heuristic = new DFSHeuristicFunction();
            double valor = heuristic.getHeuristicValue(board);
            
            if (valor < minValue) {
                minValue = valor;
                minI = i;
                minBoard = board;
            }
            if (valor > maxValue) {
                maxValue = valor;
                maxI = i;
                maxBoard = board;
            }
        }
        
        System.out.println("Minimum heuristic value: " + minValue + " at i=" + minI);
        System.out.println("Maximum heuristic value: " + maxValue + " at i=" + maxI);
        
        if (minBoard != null) {
            System.out.println("Board for minimum i=" + minI + ":");
            minBoard.pintaConsultes();
        }
        if (maxBoard != null) {
            System.out.println("Board for maximum i=" + maxI + ":");
            maxBoard.pintaConsultes();
        }

    }    
}