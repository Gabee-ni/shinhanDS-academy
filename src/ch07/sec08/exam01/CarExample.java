package ch07.sec08.exam01;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
//		myCar.run();
		
		myCar.tire = new Tire(); //Tire 객체를 주입(Inject)  
		myCar.run();
		
		myCar.tire = new HankookTire();
		myCar.run();
		
		myCar.tire = new KumhoTire();
		myCar.run();
		
		System.out.println();

		Tire[] tire = {new Tire(), new HankookTire(), new KumhoTire()};
		for(Tire t : tire) {
			myCar.tire = t;
			myCar.run();
		}
	}

}
