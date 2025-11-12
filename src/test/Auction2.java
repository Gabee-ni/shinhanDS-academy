package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Participants{
	private int idx; 
	private int amount;
	
	public Participants(int idx, int amount) {
		this.idx= idx;
		this.amount = amount;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void purchase(int price) {
		this.amount -= price;
	}
} 

public class Auction2 {
	
	public static int[] solution(int n, int[] amounts) {
		int[] answer = new int[n];
		Participants[] participants = new Participants[amounts.length];
		
		for(int i =0; i<amounts.length; i++) {
			participants[i] = new Participants(i, amounts[i]);
		}
		
		for(int i=0; i<n; i++) {
			//자본기준 내림차순, 인덱스 기준 오름차순 
			Arrays.sort(participants, (a,b)->{
				if( a.getAmount() == b.getAmount()) return a.getIdx() - b.getIdx() ; 
				return b.getAmount()-a.getAmount();
			});
			int price =0 ; 
			if(participants[0].getAmount()>participants[1].getAmount()) {
				price = participants[1].getAmount()+ 10000;
			}else {
				price = participants[0].getAmount();
			}
			participants[0].purchase(price);
			answer[i] = price;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int n = 4;
		int[] amounts = {1000000, 490000, 700000, 290000};
		int[] answer = solution(n,amounts);
		
		int n2= 6;
		int[] amounts2 = {30000, 30000, 10000};
		int[] answer2 = solution(n2,amounts2);
		
		
		System.out.println(Arrays.toString(answer));
		System.out.println(Arrays.toString(answer2));
	}
	
	
}
