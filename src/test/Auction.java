package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Auction {
	
	public static int[] solution(int n, int[] amounts) {
		int[] answer = new int[n];
		
		List<Integer> list = new ArrayList<Integer>();
		for(int num : amounts) list.add(num);
		
		for(int i=0; i<n;i++) {
			Collections.sort(list, Collections.reverseOrder());
			int price = 0;

			if(list.get(0)> list.get(1)) {
				price = list.get(1)+10000;
				
				int temp = list.get(0);
//				list.remove(0);
//				list.add(0, temp-price);
				list.set(0, temp-price);
			}
			else if(list.get(0).equals(list.get(1))) {
				price = list.get(0);
				
//				list.remove(0);
//				list.add(0, 0);
				list.set(0, 0);
			
			} 
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
