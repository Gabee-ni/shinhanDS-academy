package test;

import java.util.Scanner;

public class B5622 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] str = sc.next().split("");
		String[][] dial = {{null},{null},{"ABC"},{"DEF"},{"GHI"},{"JKL"},{"MNO"},{"PQRS"},{"TUV"},{"WXYZ"}};
		int time = 0;
		
		for(int i=0; i<str.length; i++) {
			for(int j=2; j<dial.length; j++) {
				if(dial[j][0].contains(str[i])) {
					time += (j+1);
				}
			}
		}
		System.out.println(time);

	}

}
