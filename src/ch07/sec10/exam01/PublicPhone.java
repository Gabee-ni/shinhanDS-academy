package ch07.sec10.exam01;

public class PublicPhone extends Phone {

	PublicPhone(String owner) {
		super(owner);
	}
	
	void call() {
		System.out.println("공중전화에서 전화걸기");
	}


}
