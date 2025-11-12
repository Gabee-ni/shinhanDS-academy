package ch06;

public class Member {
	//필드 
	int age;
	
	//생성자
	Member(){
		
	}
	//생성자 오버로딩
	Member(int x, int y){
		
	}
	//매개 변수의 개수가 다른 경우
	Member(int x){
		
	}
	//매개변수 타입이 다른 경우
	Member(int y, String z){
		
	}
	//매개 변수 타입의 순서가 다른 경우 -> 같은 타입인데 순서만 다른 것은 컴파일에러남. 
	Member(String z, int y){
		
	}
	
	//메서드
	int add(int x, int y) {
		System.out.println(age);
		return x+y;
	}
	
}
//자바는 절차형이 아니어서 필드또는 메서드의 선언이 호출 위치보다 밑에 위치해 있어도 오류 발생 X 
//암문적으로 필드 -> 생성자 -> 메서드 순으로 작성. 
