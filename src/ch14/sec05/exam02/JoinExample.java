package ch14.sec05.exam02;

public class JoinExample {

	public static void main(String[] args) {

		SumThread sumThread = new SumThread();
		sumThread.start(); //main 스레드와 별개로 sum스레드가 실행되고 run되기 시작. 
		
		
		//메인 스레드가 SumThread의 연산이 끝나기 전에 해당 스레드에 접근해서 getSum()을 가져와서 0값이 출력
//		try {
//		    Thread.sleep(1000);  // 1000ms = 1초 동안 현재 스레드 대기
//		} catch (InterruptedException e) {
//		    e.printStackTrace();
//		}     //이렇게 메인 메소드를 기다리게 하는 것은, sum 스레드가 언제 끝날지도 모르는데 시간을 지정해줘야 하니 비효율적. 
		
		//따라서 아래와 같이 join. -> 호출한 쪽 스레드가 해당 스레드가 종료될 때까지 일시정지. 즉, main 정지 
		try {
			sumThread.join();
		} catch (Exception e) {
		}
		

		System.out.println("1~100까지의 합 : "+ sumThread.getSum());
	}

}
