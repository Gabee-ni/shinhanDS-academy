package ch07.sec10.exam01;

public class SmartPhoneExample {

	public static void main(String[] args) {
		
		//추상 클래스 Phone
//		Phone phone = new Phone() {
//		};
		
		Phone smartPhone = new SmartPhone("홍길동");
		
		smartPhone.turnOn();
//		smartPhone.internetSearch();
		smartPhone.turnOff();
		
		Phone p = new PublicPhone("김길동");
		p.call();
		p = smartPhone; //스마트폰 객체
		p.call();
		
	}

}
