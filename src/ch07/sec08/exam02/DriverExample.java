package ch07.sec08.exam02;

public class DriverExample {

	public static void main(String[] args) {
		
		Driver driver = new Driver();
		
//		Vehicle bus = new Bus(); 
		Bus bus = new Bus(); 
		driver.drive(bus); //어떤 객체를 넣던지 간에, 이 실행문을 하나로만 사용할 수 있도록 메소드다형성 활용.
		 
		Taxi taxi = new Taxi();
		driver.drive(taxi);
		
	}

}
