package ch02;

public class Variable {

	public static void main(String[] args) {
		int age; // 정수타입인 age라는 이름의 변수를 선언. 자바는 정적타입이기에 다른 타입은 대입 불가. 
		
		//변수에 값 대입(저장)=처음 값 대입 -> 초기화
		age = 10; //대입연산
		
		//동시
		int grade = 3;
		
		//변수 카멜케이스 준수. 의미 있게 네이밍 해야함. 
		int studentAge = 10; 
		//스네이크케이스 -> DB 컬럼명에서 준수. 
		int student_age = 10;
		
		//길더라도 정확성을 위해 축약은 비추
		String companyEmployeeName = "홍길동";
		System.out.println(companyEmployeeName);
		
		byte a = 10;
		byte b = 20;
		// byte c = a+b; 가 안되는 이유는 연산이 일어나면 값의 타입이 자동으로 int로 변경되기 때문. 
		
		//char도 정수형 데이터타입임.(아스키코드값. A=65, a=97)
		char c = 'A'; char d = 65;
		//System.out.println(d);
		
		
		//실수
		float e = 3.14F; // 실수 값의 기본형이 double이기에 float를 사용하려면 뒤에 F를 붙여야 함. 이와 같은 원리로 정수 값은 기본형이 int 따라서 long에는 L붙이기
		double f = 3.14;
		
		boolean result = isDuplicatedId("125");
		
		int k = 1;
		long k2 = k; // int -> long 변환 
		short k3 =10;
		k2 = k3;
		k = k3; //작은 크기의 타입을 큰 크기의 타입에 넣을 수 있음.
		//k3= k2; 이건 큰 타입을 작은 타입에 넣으려고 해서 안됨.
		//float -> double ok. 반대는 X
		
		//기본 자료형 형변환 (강제)
		double m = 3.14;
		int m2 = (int)m;
		System.out.println(m2);
		//작은 범위 -> 큰범위(자동 가능)   큰 범위 -> 작은 범위(강제형변환) => 유실 가능성 ↑
		
		//문자열 : ""사용. ""빈값, " "
		String n2 = ""; //빈문자열이라는 값. 
		String n4 = null; //값 자체가 아예 없음.
		
		//String은 클래스 중에서 유일하게 기본자료형처럼 사용할 수 있게 함. 
		String name1 = "가빈";
		String name2 = "가빈";
//		System.out.println(name1.equals(name2));
		System.out.println(name1 == name2);
		
		//객체 
		String name3 = new String("길동");
		String name4 = new String("길동");
		System.out.println(name3==name4);

		//문자열일때 값으로 비교할때 ==비교연산자 사용하면 안됨. equals()사용해야 함. 
		System.out.println(name3.equals(name4));
		
	}
	
	//boolean 논리형타입 예시
	//아이디 중복체크
	static boolean isDuplicatedId(String id) {
		//~
		return true; //중복이 맞으면 true, 틀리면 false 메소드명과 논리형타입을 잘 보고 헷갈려하지 않기~
	}

}
