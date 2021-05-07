package project3;


public class DataPoint {

	double f1;
	double f2;
	String label;
	boolean isTest;

	public DataPoint() {
			this.f1 = 0.0;
			this.f2 = 0.0;
			this.label = "";
			this.isTest = false;
		}
	
	public DataPoint(double f1P, double f2P, String labelP, boolean isTestP) {
		this.f1 = f1P;
		this.f2 = f2P;
		this.label = labelP;
		this.isTest = isTestP;
		}
	
	public double getF1() {
		return this.f1;
		}
	
	public double getF2() {
		return this.f2;
		}
	
	public String getLabel() {
		return this.label;
		}
	
	public boolean getIsTest() {
		return this.isTest;
		}
	
	public void setF1(double f1P) {
		this.f1 = f1P;
		}
	
	public void setF2(double f2P) {
		this.f2 = f2P;
		}
	
	public void setLabel(String labelP) {
		this.label = labelP;
		}
	
	public void setIsTest(boolean isTestP) {
		this.isTest = isTestP;
		}
	
	public String toString() {
		return "(AGE: "+ f1 + ", Fare: "+ f2 + ", Label: " + label + ", isTest: " + isTest + ")\n";
	}
	
}