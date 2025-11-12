package ch06;

public class StudentVO {
	private int number; 
	private String name;
	
//	public void setNumber(int number) {
//		this.number = number;
//	}
//	public int getNumber() {
//		return this.number;
//	}
//
	
	//getter, setter 단축키 
	//shift + alt + s -> r->alt +a ->r 또는 source의 generate
	private int grade ;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}