package project2;


public class DataPointEC {

	double age;
	double fare;
	String label;
	boolean isTest;
	String pclass;
	String sex;

	public DataPointEC() {
			this.age = 0.0;
			this.fare = 0.0;
			this.label = "";
			this.isTest = false;
			this.pclass = "";
			this.sex = "";
		}
	
//	public DataPoint(double f1P, double f2P, String labelP, boolean isTestP) {
//		this.age = f1P;
//		this.fare = f2P;
//		this.label = labelP;
//		this.isTest = isTestP;
//		}
	
	public DataPointEC(double ageP, double fareP, String labelP, boolean isTestP, String pclassP, String sexP) {
		this.age = ageP;
		this.fare = fareP;
		this.label = labelP;
		this.isTest = isTestP;
		this.pclass = pclassP;
		this.sex = sexP;
	}

	public double getF1() {
		return this.age;
		}
	
	public double getF2() {
		return this.fare;
		}
	
	public String getLabel() {
		return this.label;
		}
	
	public boolean getIsTest() {
		return this.isTest;
		}

	public String getpClass() {
		return this.pclass;
		}
	
	public String getSex() {
		return this.sex;
		}
	
	
	public void setF1(double f1P) {
		this.age = f1P;
		}
	
	public void setF2(double f2P) {
		this.fare = f2P;
		}
	
	public void setLabel(String labelP) {
		this.label = labelP;
		}
	
	public void setpClass(String pclassP) {
		this.pclass = pclassP;
		}
	
	public void setSex(String sexP) {
		this.sex = sexP;
		}
	
	public String toString() {
		return "(AGE: "+ age + ", Fare: "+ fare + ", Label: " + label + ", isTest: " + isTest + ", Pclass: " + pclass  + ", Sex: " + sex + ")\n";
	}
}
	
	