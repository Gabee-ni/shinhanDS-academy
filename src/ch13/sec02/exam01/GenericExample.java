package ch13.sec02.exam01;

public class GenericExample {

	public static void main(String[] args) {

		//K를 Tv객체 타입으로 지정 -> setKind로 Tv객체만 생성 가능함. 
		Product<Tv, String> product1 = new Product<>();
		
		product1.setKind(new Tv());
		product1.setModel("스마트");
		
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		System.out.println("product1: "+ product1);
		
		
		Product<Car, String> product2 = new Product<>();
		
		product2.setKind(new Car());
		product2.setModel("SUV자동차");
		
		System.out.println("product2: "+product2);
		
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
	}

}
