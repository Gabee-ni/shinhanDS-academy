package ch07.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		System.out.println("모델 : " + myPhone.model);
		System.out.println("색상 : " + myPhone.color);
		
		System.out.println("와이파이 상태 : "+ myPhone.wifi);
		
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요 저는 홍길동인데요");
		myPhone.sendVoice("아~ 네");
		myPhone.hangUp();
		
		myPhone.setWifi(true);
		myPhone.internet();
		
		Phone p =myPhone; //자동형변환 
		SmartPhone s = (SmartPhone) p; //강제형변환 (조건:반드시 원래 자식이었다가 부모로 형변환된 객체만 가능!!!!) 원래 부모인 거를 자식으로 형변환 될 수는 없단 말. 
		
		//안 되는 경우
		Phone p2 = new Phone();
		SmartPhone s2 = (SmartPhone) p2; //컴파일에러는 안 나지만, 런타임에러 발생.
		
		
		
	}

}
