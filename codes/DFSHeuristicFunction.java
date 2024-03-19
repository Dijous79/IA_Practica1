package codes;

import aima.search.framework.HeuristicFunction;

public class DFSHeuristicFunction implements HeuristicFunction {

	public boolean equals(Object obj) {
		boolean retValue;
		
		retValue = super.equals(obj);
		return retValue;
	}

	public double getHeuristicValue(Object state) {
		DFSBoard board = (DFSBoard) state;
		int ns = board.getNServers();
		
		// Calculate mean
		double mean = 0;
		for (int i = 0; i < ns; i++) {
			mean += board.getServerTime(i);
		}
		mean /= ns;
	
		// Calculate variance
		double variance = 0;
		for (int i = 0; i < ns; i++) {
			double deviation = board.getServerTime(i) - mean;
			variance += deviation * deviation;
		}
		variance /= ns;
		
		//ponderadors
		return (mean + variance);
	}
	
	

}