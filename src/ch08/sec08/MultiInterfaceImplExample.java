package ch08.sec08;

import ch08.sec02.RemoteControl;

public class MultiInterfaceImplExample {
	public static void main(String[] args) {
		//다중 인터페이스를 implements하는 경우, 어떤 인터페이스에 객체가 대입되는지에 따라 해당 변수를 통해 호출할 수 있는 메서드가 다르다. 
		RemoteControl rc = new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		Searchable searchable = new SmartTelevision();
		searchable.search("https");
		
		//강제 형변환을 해도 실제 객체의 타입을 바꾸지는 못함. 
		//따라서 타입을 바꿔서 접근 가능한 멤버를 제한할 뿐임. 즉, searchable2가 스마트티비 객체를 가리키지만, 
		RemoteControl searchable2 = (SmartTelevision) searchable ; 
		//참조변수 타입이 리모트컨트롤러 인터페이스 이므로 해당 인터페이스의 추상 메소드만 호출 가능한 것이다. 
		searchable2.turnOn(); 
		
	}		
}
