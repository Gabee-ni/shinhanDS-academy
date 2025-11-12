package ch16.sec04;


public class LambdaEx {

	public static void main(String[] args) {
		Person person = new Person();
		
		//실행문이 두 개 이상
		person.action((x,y)->{
			double result = x+y;
			return result;
		});
		
		//return문이 하나만 있을 경우 생략 가능(연산식)
		person.action((x,y)->(x+y));
		
		//return문이 하나 (메소드 호출)
		person.action((x,y)->sum(x,y));
	}
	
	public static double sum(double x, double y) {
		return x+y;
	}
}
