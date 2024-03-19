package codes;

import codes.DFSBoard;

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
		//osigui el size dels "contenidors" no buits
		
		double mean = 0;
		double variance = 0;
	
		for (int i = 0; i < ns; i++) {
			double serverTotalTime = board.getServerTime(i);
			mean += serverTotalTime;
			variance += Math.pow(serverTotalTime, 2);
		}
	
		mean /= ns;
		variance = variance / ns - Math.pow(mean, 2);
	
		return (mean + variance);
	}
	

}