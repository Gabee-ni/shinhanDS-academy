package ch16.sec05.exam02;

public class MethodReferenceExample {

	public static void main(String[] args) {

		Person person = new Person();
		//(a,b) -> a.compareToIgnoreCase(b);
		//String클래스 안에 있는 인스턴스 메소드 
		person.ordering(String::compareToIgnoreCase);
	}

}
