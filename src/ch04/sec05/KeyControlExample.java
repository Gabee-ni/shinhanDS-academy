package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true; //flag 변수 
		int speed = 0;
		
		while(run) {
			System.out.println("------------------");
			System.out.println("1. 증속 | 2. 감속 | 3.중지");
			System.out.println("------------------");
			System.out.println("선택");
			
			String strNum = sc.nextLine();
			
			//비교할 대상을 앞에 작성하는 버릇 들이기 
			if("1".equals(strNum)) {
				speed++;
				System.out.println("현재속도 = "+ speed);
			}else if("2".equals(strNum)) {
				speed--;
				System.out.println("현재속도 = "+ speed);
			}else if("3".equals(strNum)) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}
}
