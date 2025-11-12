package ch14.sec06.exam01;

public class SynchronizedExample {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		
		User1Thread user1Thread = new User1Thread();
		//user1과 usder2 스레드 각각 Setter메서드에 객체를 주입해준 것. 
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();
	}

}
