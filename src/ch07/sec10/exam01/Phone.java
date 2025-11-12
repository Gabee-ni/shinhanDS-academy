package ch07.sec10.exam01;

public abstract class Phone {
	
	String owner;
	
	//자식클래스에서 생성자가 선언에서 부모클래스 생성자가 호출되므로 필요함. 
	Phone(String owner){
		this.owner = owner;
	}
	
	void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	void turnOff() {
		System.out.println("전원을 끕니다.");
	}

	//자식클래스에서 만든 메서드가 부모의 추상클래스에 없으면 에러발생. 
	//추상메서드 -> 자식 클래스에도 무조건 해당 메서드가 존재해야함. 
	//추상 메서드가 하나라도 있으면 해당 클래스는 추상클래스를 명시해야 함. 
	abstract void call();
	
	//이렇게 하면 자식클래스에서 call이 아닌 calling이라는 메서드 명이 생길 수 있음. 이를 방지하기 위해 추상메서드 필요.
//	void call() {
//		
//	}
}
