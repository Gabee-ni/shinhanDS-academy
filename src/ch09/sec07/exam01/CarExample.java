package ch09.sec07.exam01;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		
		car.run1();
		car.run2();
		
		//이거를 익명 객체로 하기에는 코드가 길어지니까 아무리 1회용이라 하더라도 클래스를 생성하는게 좋음. 
		car.run3(new Tire() {
			
			@Override
			public void roll() {
				System.out.println("tire 갹체 3 굴러감");
				
			}

			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
		});
		
		//Tire를 인터페이스로 변경하면 람다식 사용 가능하다.
		//TIre의 추상 메서드가 현재는 1개여서 가능. 2개면 안됨.  
//		car.run3(()->{
//			System.out.println("일반 타이어 회전");
//		});
		

	}

}
