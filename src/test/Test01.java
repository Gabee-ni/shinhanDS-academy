package test;

public class Test01 {
	/*
	 * 1. 반복하면서 잔고 확인해서 요청처리 후 잔고가 (-m) 이상이면 출금 가능, 아니면 거절
	 * 요청이 + 입금, - 출금
	 * 요청 길이는 배열의 길이마늠 	 
	 * */

	public static void main(String[] args) {
		Test01 t1 = new Test01();
		int answer = t1.solution(6000, new int[]{10000, -13000, -4000, -2000, 6500, -20000});
		System.out.println(answer);
	}
	
	public int solution (int m, int[] ledger) {
		int account22 = 0;
		m *= -1; //반복문 안에서 계산하기 보다는 미리 하기. 
		for(int i=0 ; i<ledger.length ; i++) {
			int result =account22 +ledger[i];  
			//음수 양수 체크 X -> 배열에 있는 원소 그냥 더하기ㅁ나 하면 되니께롱 
			if(result >= m) { //비교 
					account22 += ledger[i] ; 
				}
		}
	

		return account22;
	}
}
