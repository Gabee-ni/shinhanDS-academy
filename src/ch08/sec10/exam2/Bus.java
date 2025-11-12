package ch08.sec10.exam2;

public class Bus implements Vehicle {

	@Override
	public void run() {

		System.out.println("버스가 달립니다");
		
	}
	
	//추가 메서드
	public void CheckFare() {
		System.out.println("승차요금을 체크합니다.");
	}

}
