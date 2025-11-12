package ch07.sec02;

public class SmartPhone extends Phone {
	public boolean wifi;
	
	public SmartPhone() {
//	super()가 숨어 있음.
	}
	public SmartPhone(String model, String color) {
//		super();
		super("모델");
		
		System.out.println("자식 생성자");
		this.model = model;
		this.color = color;
	}
	//메서드 오버라이딩
	@Override //실수 방지를 위해 어노테이션 활용하기!
	public void bell() {
		System.out.println("새로운 벨소리");
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경");
		
	}
	public void internet() {
		System.out.println("인터넷 연결");
	}
	
	void internetSearch() {
		System.out.println("인터넷 검색");
	}
	
	
}
