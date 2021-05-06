package project2;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class DummyPredictor extends PredictorEC {

	public ArrayList<DataPointEC> readData(String filename) {
		ArrayList<DataPointEC> dataPoint = new ArrayList<DataPointEC>(2);
			
	    try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
	            double f1 = sc.nextDouble();
	            double f2 = sc.nextDouble();
	            String label = sc.next();
	            boolean isTest = sc.nextBoolean();
	            String pclass = sc.next();
	            String sex = sc.next();
	            DataPointEC test = new DataPointEC(f1,f2,label,isTest,pclass,sex);
	            dataPoint.add(test);
            	}
            }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
			e.printStackTrace();
            }
	    
		return dataPoint;
	}
	
	public String test(DataPointEC data) {
		double average = (data.getF1()+data.getF2())/2;
		System.out.println("Average of f1 and f2: " + average);
		
		return data.getLabel();
	}

	public Double getAccuracy(ArrayList<DataPointEC> data) {
		return 2.718;
	}
	
	public Double getPrecision(ArrayList<DataPointEC> data) {
		return 0.577;
	}

}
