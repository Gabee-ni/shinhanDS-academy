package ch12.sec09;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {

		double num = 1234567.89;
		
		DecimalFormat df;
		
		//0:없으면 자리수 채움. #은 없어도 상관 없음. 
//		df = new DecimalFormat("00000000000000.###");
		
		//정수 자리까지 출력 -> 0.89가 출력안되고 반올림 되어서 7대신에 8로 출력 
		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		//무조건 소숫점 첫째 자리까지 출력. -> 정수만 되어 있으면 0으로 채워서라도 출력. 
		df = new DecimalFormat("#,###.0");
		System.out.println(df.format(num));
		
	}

}
