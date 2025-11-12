package ch12.sec03.exam05;

public class Main {

	public static void main(String[] args) {
		
		Member m = new Member();
		
		m.setName("홍길동");
		m.setAge(10);
		m.setId("id");
		
		System.out.println(m.getAge());
		System.out.println(m.getId());
		System.out.println(m.getName());
		
	}

}
