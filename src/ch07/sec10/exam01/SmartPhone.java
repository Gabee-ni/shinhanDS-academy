package ch07.sec10.exam01;

public class SmartPhone extends Phone {
	
	
	SmartPhone(String owner) {
		super(owner);
	}
	
	void internetSearch() {
		System.out.println("인터넷 검색");
	}
	
	void call() {
		System.out.println("스마트폰에서 전화걸기");
	}
	
	
}
