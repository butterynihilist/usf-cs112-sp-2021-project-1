package project1;

import javax.swing.*;    // all of the Swing objects
import java.awt.*;       // more windowing components, including Container
import java.util.*;

public class MainDriver {
	public static void main(String[] args) {
		
		
		DummyPredictor dummy = new DummyPredictor();
		ArrayList<DataPoint> dataPoint = dummy.readData("DataFile.txt");
		DataPoint d1 = new DataPoint(dataPoint.get(0).getF1(),dataPoint.get(0).getF2(),dataPoint.get(0).getLabel(),dataPoint.get(0).getIsTest());
		DataPoint d2 = new DataPoint(dataPoint.get(1).getF1(),dataPoint.get(1).getF2(),dataPoint.get(1).getLabel(),dataPoint.get(1).getIsTest());
		
		System.out.println(dummy.test(d1));
		System.out.println(dummy.test(d2));
		
		
		
		JFrame myFrame = new JFrame();
		Container contentPane = myFrame.getContentPane();
		myFrame.setTitle("Project 1 | Berkeley Phan");

		contentPane.setLayout(new FlowLayout());
		contentPane.setLayout(new GridLayout(3,2));
		myFrame.getContentPane().setBackground(Color. BLACK);

		contentPane.add(new JButton(new ImageIcon("sad_cat.png")));
		contentPane.add(new JButton("Euler's Number: " + dummy.getAccuracy(dataPoint).toString() ));
		contentPane.add(new JButton("Euler–Mascheroni constant: " + dummy.getPrecision(dataPoint).toString() ));
		
		myFrame.pack();
		myFrame.setVisible(true);

	}

}
