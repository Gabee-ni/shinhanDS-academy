package ch06;

public class Car {
	String company = "현대자동차";
	String model ;
	String color;
	boolean start ;
	int speed;
	int maxSpeed;
	
	//생성자가 없으면 컴파일러가 자동으로 기본생성자를 생성. 기본생성자(매개변수가 없는 생성자)
	//다른 생성자가 있으면, 기본 생성자를 자동생성해주지 않기에, 별도로 만들어야 함. 

	//static 블럭  -> 가장 먼저 시
	static {
		System.out.println("static 블록 실행");
	} 
	//instance 블록 -> 객체 생성마다
	{
		System.out.println("instance 블록 실행");
	}
	
	Car() {
		//초기화작업이 필요하면 여기
//		model = "소나타"; //객체생성을 안 해주면 이것도 초기화 안됨. 
		System.out.println("생성자 호출");
	}
	Car(String model, String color){
//		this.model = model;
//		this.color = color;
		this(model,color,250); //중복 코드를 줄이기 위해 가장 많은 매개값을 갖는 생성자를 호출하도록 기본값을 넣어준것. 
	}
	
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
