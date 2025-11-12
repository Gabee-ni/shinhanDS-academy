package ch04.problem;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		//3번 -> 3의 배수 구하기 (이 방식 외에 %3 ==0 이용도 가능 
		System.out.println("-----------3----------");
		int sum = 0;
		for(int i=3; i<=100; i+=3) {
			sum+=i;
		}
		System.out.println(sum);
		
		
		//4 -> 두 주사위 눈의 합이 5가 되면 종료
		System.out.println("-----------4----------");
		boolean run = true;
		
		while(run) {
			int n1 = (int)(Math.random()*6)+1;
			int n2 = (int)(Math.random()*6)+1;
			
			if(n1+n2==5) {
				System.out.println("("+n1+","+n2+")");
				run = false;
			}else {
				System.out.println("("+n1+","+n2+")");
			}
		}
		
		//5-> 4*x+5*y==60 해 모두 구하기 
		System.out.println("-----------5----------");
		for(int x=0;x<=10;x++) {
			for(int y=0;y<=10;y++) {
				if (4*x+5*y==60) {
					System.out.println("("+x+","+y+")");
				}
			}
		}
		
		//6 별찍기
		System.out.println("-----------6----------");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//7 
		System.out.println("-----------7----------");
		Scanner sc = new Scanner(System.in); //객체를 생성하는 행위가 메모리를 차지하기에 밖에서 생성.
		int balance =0;
		boolean flag = true;
		
		while(flag) {
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("--------------------------------");
			System.out.print("선택> ");
			
			String str = sc.nextLine();
			
			if("1".equals(str)) {
				System.out.print("예금액>");
				
				String depositPrice = sc.nextLine();
				balance += Integer.parseInt(depositPrice);
				
			}else if("2".equals(str)) {
				System.out.print("출금액>");
				
				String withdrawPrice = sc.nextLine();
				balance -= Integer.parseInt(withdrawPrice);
				
			}else if("3".equals(str)) {
				System.out.println("잔고>" + balance );
				
			}else if("4".equals(str)) {
				System.out.println("프로그램 종료");
				flag = false;
				
			}
		}
		
		
	}

}
