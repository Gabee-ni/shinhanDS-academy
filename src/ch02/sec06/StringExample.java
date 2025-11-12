package ch02.sec06;

public class StringExample {

	public static void main(String[] args) {
		String name = "홍길동";
		String job = "프로그래머";
		
		System.out.println(name);
		System.out.println(job);

		//따옴표, 쌍따옴표 처리는 \로 감싸서 하기 
		String str = "나는 \"자바\"를 배웁니다.";
		System.out.println(str);
		
		//tab 범위 만큼 공백주기 
		str = "번호\t이름\t직업";
		System.out.println(str);
		
		//줄바꿈 
		System.out.print("나는\n");
		System.out.print("자바를\n");
		System.out.print("배웁니다.\n");
		
		System.out.print("나는\n자바를\n배웁니다.\n");
		
		//""" """로 감싸면 이스케이프문자를 유지하며, 따옴표와 큰따옴표 처리가 편리해짐. 자바 13이상부터 가능. 
		String text = """
				나는\n
				\t"자바"를
				\"배웁\"니다.
				""";
		
		System.out.println(text);
		
		
		//문자열도 연산 가능함. 
		String n = "홍길동";
		String n2 = n + "님";
		System.out.println(n2);
		
		//자동형변환 가능
		String n3 = "3"+1;
		System.out.println(n3);
		
		//원래는
		String n4 = "3" + String.valueOf(1);
		//문자 + 숫자 -> 숫자가 문자로 형변환 -> 이를 활용하여 숫자를 문자로 형변환 할 때 + "" 를 활용.  
		int age =10;
		String age2 = age+ ( 3 + "") ;
		System.out.println(age2);
		
		//문자열 int 파싱
		int age3 = Integer.parseInt(age2)+10;
		System.out.println(age3);
		
//		//정수 클래스.
//		Integer age4 = new Integer(100);
//		System.out.println(age4);
		
		
		
	}

}
