package ch13.sec02.exam02;

public class GenericExample {

	public static void main(String[] args) {

		HomeAgency homeAgency = new HomeAgency();
		Home home = new Home();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car car = new Car();
		car.run();
	}

}
