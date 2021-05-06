package project2;

import java.util.*;


public abstract class PredictorEC {

	abstract ArrayList<DataPointEC> readData(String filename);	
	
	abstract String test(DataPointEC data);
		
	abstract Double getAccuracy(ArrayList<DataPointEC> data);
		
	abstract Double getPrecision(ArrayList<DataPointEC> data);
		
	}

