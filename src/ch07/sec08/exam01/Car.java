package ch07.sec08.exam01;

public class Car {
	public Tire tire;	//Tire타입의 객체가 주입. 외부에서 주입됨. 
	
	public void run() {
		tire.roll();
	}
}
