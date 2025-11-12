package ch04.sec02;

public class IfExample {

	public static void main(String[] args) {
		int score = 93;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}else {
			System.out.println("else");
		}
		
		if(score <90) System.out.println("점수가 90보다 작습니다."); // 대부분 1문장의 경우 바로 옆에 작성~
//			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다."); //중괄호가 없어서 if의 실행문 기본 1줄 외 다른 줄은 조건과 다르게 실행. 따라서 들여쓰기 잘 맞추기
			
		//score가 90이상이면 A 80이상이면 B 나머지 C
		if(score >=90) {
			System.out.println("A");
		}else if(score>=80) {
			System.out.println("B");
		}else {
			System.out.println("C");
		}
		
		//주사위
		int n = (int)(Math.random()*6)+1;
		System.out.println(n);
		
		//동전 앞/뒤
		int coin = (int)(Math.random()*2);
		System.out.println(coin);
		
		
		
		
		
		
		
	}

}
