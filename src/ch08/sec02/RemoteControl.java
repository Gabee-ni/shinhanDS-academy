package ch08.sec02;

public interface RemoteControl {
	//추상메서드
	//public abstract void 메서드 명 : 일반 클래스에서는
	//하지만 인터페이스에서는 아래와 같이 사용 가능. 
	void turnOn();
	void turnOff();
	
	//상수
	//public static final
	double PI = 3.14;
	
	//default 메서드 -> 추상 메서드와 구분하기 위해서 꼭 default 키워드를 사용해야 함. 
	//public
	default int add(int x, int y) {
		test();
		return x+y;
	}
	
	//static 메서드-> 인터페이스 명으로 직접 접근해서 사용 가능.
	//public static
	static void test() {
		test3();
	}
	
	//private는 인터페이스 내부에서만 사용 가능. 
	private void test2() {
		
	}
	
	private static void test3() {
		
	}
	
}
