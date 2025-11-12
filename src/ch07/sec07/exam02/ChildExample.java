package ch07.sec07.exam02;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		
		//부모타입의 변수에 자식타입의 객체를 대입(자동형변환)
		Parent parent = child;
		
//		child.method1();
		parent.method1(); //부모한테 있던 메서드
		parent.method2(); //부모도 O, 자식도O / 타입이 부모(형변환된 경우에만 재정의된 메소드가 실행)
		
		Child child2 = (Child)parent; //원래 child였기에 다시 자식타입으로 강제형변환 가능. 
		child2.method3();
		
		Parent parent2 = new Parent();
		
		parent2.method1();
		parent2.method2();
//		parent2.method3(); //없음.
		
		
	}

}
