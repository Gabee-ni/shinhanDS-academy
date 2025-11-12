package test;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int solution (int tickets, int[][] requests) {
		int soldTickets = 0;
		
		//등급 기준 오름 차순
		Arrays.sort(requests, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				//등급 같은 경우 수량 기준 내림 차순
				if(o1[0]==o2[0]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});
		
		System.out.println(Arrays.deepToString(requests));
	
		int remainTickets = tickets;
		//배열 순회 하며 티켓 팔기
		for(int i=0; i<requests.length;i++) {
				if(requests[i][1] > remainTickets) continue;
				else remainTickets -=requests[i][1];
		}
		soldTickets = tickets- remainTickets;
		return soldTickets;
	}
}

public class TicketSol {

	public static void main(String[] args) {
		
		Solution sol1 = new Solution();
		int[][] arr1 = {{2,3},{1,7},{2,4},{3,5}};
		int[][] arr2 = {{1,9},{3,6},{2,5}};
		int[][] arr3 = {{3,1},{2,5},{2,10},{3,8},{1,2}};
		
		System.out.println(sol1.solution(10, arr1));
		System.out.println(sol1.solution(8, arr2));
		System.out.println(sol1.solution(20000, arr3));
	}

}
