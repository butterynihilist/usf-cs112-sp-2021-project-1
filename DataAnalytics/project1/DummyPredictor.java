package project1;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DummyPredictor extends Predictor {

	public ArrayList<DataPoint> readData(String filename) {
		ArrayList<DataPoint> dataPoint = new ArrayList<DataPoint>(2);
			
	    try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
	            double f1 = sc.nextDouble();
	            double f2 = sc.nextDouble();
	            String label = sc.next();
	            boolean isTest = sc.nextBoolean();
	            DataPoint test = new DataPoint(f1,f2,label,isTest);
	            dataPoint.add(test);
            	}
            }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
			e.printStackTrace();
            }
	    
		return dataPoint;
	}
	
	public String test(DataPoint data) {
		double average = (data.getF1()+data.getF2())/2;
		System.out.println("Average of f1 and f2: " + average);
		
		return data.getLabel();
	}

	public Double getAccuracy(ArrayList<DataPoint> data) {
		return 2.718;
	}
	
	public Double getPrecision(ArrayList<DataPoint> data) {
		return 0.577;
	}

}
