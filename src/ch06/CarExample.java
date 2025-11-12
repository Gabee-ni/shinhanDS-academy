package ch06;

import java.util.Scanner;

import util.Util;

public class CarExample {


	public static void main(String[] args) {
		Car myCar = new Car();
		
		System.out.println("모델명 : "+myCar.model);
		System.out.println("시동여부 : "+myCar.start);
		System.out.println("현재속도 : "+myCar.speed);
		System.out.println("제작회사 : "+myCar.company);
		System.out.println();
		
		Car myCar2 = new Car("자가용","빨강");
		
		System.out.println(myCar2.company);
		System.out.println(myCar2.model);
		System.out.println(myCar2.color);
		System.out.println();
		
		Car myCar3 = new Car("택시","검정",200);
		System.out.println(myCar3.company);
		System.out.println(myCar3.model);
		System.out.println(myCar3.color);	
		System.out.println(myCar3.maxSpeed);
		System.out.println();
		
		double a = 0;
		CarExample ce = new CarExample();
//		testMember(0); //정적인 메서드(메인)가 동적인 메서드를 참조할 수 없음.
		ce.testMember(0);
		
		
		//static과 instance
		Math.random(); //static 메서드. 클래스만 가지고 사용 static 메서드 
		double pi = Math.PI; //static field
//		Scanner sc = new Scanner(System.in); 
//		sc.next();//객체를 생성해야만 사용할 수 있음. 인스턴스 메서드
		int age = ce.age; //ce 객체를 생성해야만 사용 가능. instance field
		
//		Math m = new Math(); -> 이 클래스는 왜 객체생성 X ? -> Math의 기본생성자를 private로 지정했기에 객체 생성 안됨. 
		double height = ce.height; //static 필드인데, 객체 생성 후 사용가능. -> static이 고정의 의미도 가지기 때문
		
		CarExample ce2 = new CarExample();
		ce.age = 10;
		System.out.println(ce2.age); //객체들끼리는 독립적임. 
		ce.height = 180;
		System.out.println(ce2.height); //객체들끼리는 독립적인데, ce의 필드를 변경했더니 ce2가 변경됨. Why, static이니까.
		//따라서 static이 정적인 의미를 갖지만 동시에 공유의 의미도 갖는다는 소리
		
		System.out.println(Util.COMPANY_NAME);//상수로 지정하여 무분별한 객체생성 없이 사용가능.
		Util.tagRemove("내용");
		
	}
	//static : 정적(고정) + 공유
	static double height = 0;
	int age=0 ;//instance 필드 
	
	void test() {
		
	}
	
	double testMember(int x) {
		x++;
		test(); //다른 메서드 실행 가능. 
		return 0;
	}
	
	
	
	

}
