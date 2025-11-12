package ch02.sec13;

import java.util.Scanner;


public class ScannerExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x값 입력 : ");
		//sc.nextLine()은 Java의 Scanner 클래스에서 입력 버퍼에 남아있는 “다음 한 줄 전체”를 문자열로 읽는 메서드
		String strX = sc.nextLine();
		int x = Integer.parseInt(strX);
		
		System.out.print("y값 입력 : ");
		String strY = sc.nextLine();
		int y = Integer.parseInt(strY);
		
		int result = x + y ;
		System.out.println("x + y :" + result );
		System.out.println();
		
		//확장 
		while(true) {
			System.out.print("입력 문자열 : ");
			
			String data = sc.nextLine();
			if(data.equals("q")) {
				break;	
			}
			
			System.out.println("출력문자열 : "+ data);
			System.out.println();
		}
		System.out.println("종료");
		
		//import는 다른 디렉토리에 있는 클래스나 외부 라이브러리의 클래스를 사용하기 위해 불러올 때 사용. 
//		Main m = new Main(); // test 패키지에 있는 Main 클래스 형식으로 객체를 생성하는데, import 해오면 오류가 안 남. 
		
		//습관 들이기 : 비교하고자 하는 값을 앞에 적기. 
		String data = null; 
//		System.out.println(data.equals("q")); // 널포인트 익셉션 발생
		System.out.println("q".equals(data)); //false 발생 
 		
		sc.close();
		
		

	}

}
