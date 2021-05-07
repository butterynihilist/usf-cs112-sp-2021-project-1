package project3;

import java.util.*;
import java.io.*;

public class KNNPredictor extends Predictor {

	private int fareCOL = 6;
	private int ageCOL = 5;
	private int survivalCOL = 1;

	private int k;
	private int survived = 0;
	private int deceased = 0;

	ArrayList<DataPoint> datapoints = new ArrayList<DataPoint>();

	public KNNPredictor(int kParam) {
		this.k = kParam;
	}

	private List<String> getRecordFromLine(String line) {

		List<String> values = new ArrayList<String>();

		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}

	public ArrayList<DataPoint> readData(String filename) {

		Random random = new Random();

		try (Scanner scanner = new Scanner(new File("titanic.csv"));) {

			survived = 0;
			deceased = 0;

			int line = 0;
			int dirtyData = 0;
			boolean isTest = false;

			scanner.nextLine();

			while (scanner.hasNextLine()) {
				line++;

				List<String> records = getRecordFromLine(scanner.nextLine());

				if (records.get(5).equals("") || records.size() != 7) {
					dirtyData++;
				} else {
					double age = Double.parseDouble(records.get(ageCOL));
					double fare = Double.parseDouble(records.get(fareCOL));
					String label = records.get(survivalCOL);

					if (random.nextDouble() < 0.9) {
						isTest = false;
						if (String.valueOf(label).equals("1")) {
							survived++;
						} else {
							deceased++;
						}
						datapoints.add(new DataPoint(age, fare, label, isTest));

					} else {
						isTest = true;
						datapoints.add(new DataPoint(age, fare, label, isTest));
					}
				}
			}

//			System.out.println("Survivors: " + survived);
//			System.out.println("Deceased: " + deceased);


		} catch (FileNotFoundException e) {
			System.out.println("File not found");

		}
		return datapoints;
	}

	private double getDistance(DataPoint p1, DataPoint p2) {
		double distance = 0.0;

		double x1 = p1.getF1(), y1 = p1.getF2();
		double x2 = p2.getF1(), y2 = p2.getF2();

		distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		return distance;
	}

	@Override
	public String test(DataPoint data) {

		int trainingTotal = survived + deceased;
		Double[][] arr = new Double[trainingTotal][2];

		int r = 0;
		String result = "";

		if (data.getIsTest() == true) {
			for (int i = 0; i < datapoints.size(); i++) {
				if (datapoints.get(i).getIsTest() == false) {
					Double distance = getDistance(data, datapoints.get(i));
					Double label = Double.parseDouble(datapoints.get(i).getLabel());

					arr[r][0] = distance;
					arr[r][1] = label;
					r++;
				}
			}

			java.util.Arrays.sort(arr, new java.util.Comparator<Double[]>() {
				public int compare(Double[] a, Double[] b) {
					return a[0].compareTo(b[0]);
				}
			});

			int survived2 = 0;
			int deceased2 = 0;

			for (int i = 0; i < k; i++) {
				if (arr[i][1] == 1) {
					survived2++;
				} else {
					deceased2++;
				}
			}

			if (survived2 > deceased2) {
				result = "1";
			} else {
				result = "0";
			}
		}
		return result;
	}

	double truePositive = 0;
	double trueNegative = 0;
	double falsePositive = 0;
	double falseNegative = 0;

	Double getAccuracy(List<DataPoint> data) {
		for (int i = 0; i < data.size(); i++) {
			String label = test(data.get(i));
			if (label.equals("1")) {
				if (data.get(i).getLabel().equals("1"))
					truePositive++;
				else if (data.get(i).getLabel().equals("0"))
					falsePositive++;
			} else if (label.equals("0")) {
				if (data.get(i).getLabel().equals("1"))
					falseNegative++;
				else if (data.get(i).getLabel().equals("0"))
					trueNegative++;
			}
		}
		double result = (truePositive + trueNegative) / (truePositive + trueNegative + falsePositive + falseNegative);
		return result;

	}

	Double getPrecision(List<DataPoint> data) {
		for (int i = 0; i < data.size(); i++) {
			String label = test(data.get(i));
			if (label.equals("1")) {
				if (data.get(i).getLabel().equals("1"))
					truePositive++;
				else if (data.get(i).getLabel().equals("0"))
					falsePositive++;
			} else if (label.equals("0")) {
				if (data.get(i).getLabel().equals("1"))
					falseNegative++;
				else if (data.get(i).getLabel().equals("0"))
					trueNegative++;
			}
		}
		return truePositive / (truePositive + falseNegative);
	}

	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		return null;
	}

	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		return null;
	}

}
