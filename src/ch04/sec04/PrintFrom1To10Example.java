package ch04.sec04;

public class PrintFrom1To10Example {

	public static void main(String[] args) {
		//for (초기화식 ; 조건식 ; 증감)
		//실행순서 1->2->실행문->3->2->...
		for(int i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//구구단 -> 중첩반복문의 기본
		for(int i=2; i<=9; i++) {
			System.out.println("***********"+ i +"단***********");
			for(int j=1;j<=9;j++) {
				System.out.println(i +" X "+ j + " = "+ i*j);
			}
		}

	}

}
