package ch08.sec10.exam2;

public class CastingExample {

	public static void main(String[] args) {

		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare(); -> 실행 안됨. 인터페이스 타입으로 형변환 된 객체에 해당 메소드가 없기에.
		
		Bus bus = (Bus) vehicle;
		bus.run();
		bus.CheckFare();
	}

}
