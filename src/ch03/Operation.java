package ch03;

public class Operation {

	public static void main(String[] args) {

		//둘 중 하나 이상이 꼭 실수여야 함. 
		double num = 10/3.0;
		System.out.println(num);
		
		//비교연산은 결과값이 반드시 boolean T/F
		System.out.println( 90 != 80);
		
		//논리연산도 결과값이 boolean
		//shortcut
		// A && B : A가 F면 B 확인할 필요 X
		// A || B : A가 T면 B 확인할 필요 X    -> 자바가 실제로 이렇게 동작. 
		String name = null;
		System.out.println( "메롱".equals("미룽") && 90 == 90);
		System.out.println(  90 == 90 || "메롱".equals("미룽"));
		
		//삼항연산
		int score = 90;
		String result = (score>=60)? "합격" : "불합격";
		System.out.println(result);
		
		char grade = (score >= 90 )? 'A' : ((score>= 80) ? 'B': 'C');
		System.out.println(grade);
		
		
		//챕터3 확인문제 3번
		int pencils = 534;
		int student = 30;
		
		int pencilsPerStudent = pencils/student;
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = pencils % student;
		System.out.println(pencilsLeft);
		
		//4번
		int value = 356;
//		System.out.println((value/100)*100);
		System.out.println(value - (value%100));
		
		
	}

}
