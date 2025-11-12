package ch11;

public class ExceptionEx {

	//test() try로 안 처리할 거면 메소드를 실행하는 곳도 throws로 동일 에러를 같이 던지면 처리됨. ->JVM이 초ㅣ종적으로 처리
//	public static void main(String[] args)  throws InterruptedException{
	public static void main(String[] args)  {
		System.out.println("시작");
		
		int a =18;
		int b =0;
//		int b =2;
		int c =0;
		int[] arr = {1,2,3};
		String name = null;
		
		test(); //RunTimeException 던지고 있고, main()에서 throws 안 하고 있는데 왜 에러X?
		//main()에 명시되어 있지 않지만 throws로 Runtime 에러를 처리하고 있는 것. 
		
//		try {
//		test(); 
//		}catch(InterruptedException e){
//			
//		}
		
		
		try {//시도
//			int c = a/b; //예외 발생(프로그램 중지) -> try안에 있어야 캐치가능
			c = a/b;
			
			System.out.println(arr[2]);
			
			System.out.println(name.length());
			System.out.println("실행문 마지막"); //위 코드가 오류나면 실행X
			
			Class.forName("java.lang.String");
			
		} catch (ArithmeticException e) { //잡아냄
			System.out.println("예외발생");
			System.out.println(e.getMessage());
//			System.out.println(e.toString());
//			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 예외발생");
//		} catch (Exception e) { //모든 예외를 다 잡아냄. 대부분 가장 상위 클래스인 Exception으로 캐치함.
//			System.out.println("모든 예외처리");
		} catch(ClassNotFoundException e) {
			
		} finally {
			System.out.println("항상 실행");
		}
		
		
		System.out.println(c); // c의 범위가 try{}안이라서 오류 발생 -> 선언을 밖에서 하면 가능
		System.out.println("끝");
		
		
//		try {
//			test1();
//		} catch (SomeException e) {
//			e.printStackTrace();
//		}
	
	}
	public static void test() throws RuntimeException{
		//	
	}
	
//	public static void test1() throws SomeException{
//		throw new SomeException("어떤 오류 발생");
//	}
	
	public static void test1() {
		int r =0;
		try {
			throw new SomeException("어떤 오류 발생");
		} catch (SomeException e) {
			r =1;
			System.out.println(e.getMessage());
			
		}
	}

}


class SomeException extends Exception{
	public SomeException() {
		
	}
	
	public SomeException(String msg) {
		super(msg);
	}
}
















