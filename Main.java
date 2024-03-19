import IA.DistFS.Servers;
import codes.DFSBoard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Servers.WrongParametersException {
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
        prova.pintaConsultes();
    }
}
