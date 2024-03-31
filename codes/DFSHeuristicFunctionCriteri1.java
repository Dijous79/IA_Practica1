package codes;

import aima.search.framework.HeuristicFunction;

public class DFSHeuristicFunctionCriteri1 implements HeuristicFunction {

	public boolean equals(Object obj) {
		boolean retValue;
		
		retValue = super.equals(obj);
		return retValue;
	}

	public double getHeuristicValue(Object state) {
		DFSBoard board = (DFSBoard) state;
		
		double max = (double) board.getTempsMax();

		return max;
	}
	
	

}