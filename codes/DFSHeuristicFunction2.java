package codes;

import aima.search.framework.HeuristicFunction;

public class DFSHeuristicFunction2 implements HeuristicFunction {

	public boolean equals(Object obj) {
		boolean retValue;
		
		retValue = super.equals(obj);
		return retValue;
	}

	public double getHeuristicValue(Object state) {
		DFSBoard board = (DFSBoard) state;
		int ns = board.getNServers();
		
		double max = (double) board.getTempsMax();

		// Calculate mean
		double mean = 0;
		for (int i = 0; i < ns; i++) {
			mean += board.getServerTime(i);
		}
		mean /= ns;

		return mean + max;
	}
	
	

}