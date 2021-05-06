package project2;

import javax.swing.*; // all of the Swing objects
import java.awt.*; // more windowing components, including Container
import java.text.DecimalFormat;
import java.util.*;


public class MainDriver {
	
	static double accuracy;
	static double precision;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int k;
		do {
			System.out.println("Enter an odd integer, k: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter an odd integer!");
				scanner.next();
			}
			k = scanner.nextInt();
		} while (k % 2 == 0);
		System.out.println("k = " + k);

		KNNPredictorEC predictor = new KNNPredictorEC(k);

		ArrayList<DataPointEC> data = new ArrayList<DataPointEC>();

		data = predictor.readData("titanic.csv");

		accuracy = predictor.getAccuracy(data) * 100;
		precision = predictor.getPrecision(data) * 100;
		System.out.println("Accuracy: " + accuracy + "%");
		System.out.println("Precision: " + precision + "%");
		System.out.println(predictor.countDemographics(data));

		scanner.close();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initAndShowGUI();
			}
		});
	}

	private static void initAndShowGUI() {
		JFrame dataFrame = new JFrame();

		Container contentPane = dataFrame.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));
	
		DecimalFormat dec = new DecimalFormat("00.000");

		JButton accuracyButton = new JButton("Accuracy: " + dec.format(accuracy) + "%");
		JButton precisionButton = new JButton("Precision: " + dec.format(precision) + "%");

		contentPane.add(accuracyButton);
		contentPane.add(precisionButton);

		dataFrame.setTitle("KNN Algorithm");
		dataFrame.pack();
		dataFrame.setVisible(true);
		
	}

}
