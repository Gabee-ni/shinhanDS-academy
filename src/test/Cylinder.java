package test;

public class Cylinder {
	
	public int radius;
	public int height;
	
	public Cylinder() {
		
	}

	public double getVolume() {
		return Math.pow(radius, 2)*Math.PI*(double)height;
		
	}
	
	public double getArea() {
		//지름 * 높이 + 원 넓이 2개 
		double diameter = 2*Math.PI*radius*height;
		return diameter + 2*(Math.PI*Math.pow(radius, 2)); 
	}

 	

}
