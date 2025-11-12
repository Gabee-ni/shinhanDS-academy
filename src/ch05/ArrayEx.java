package ch05;

import java.util.Arrays;

public class ArrayEx {
	int age;
	public static void main(String[] args) {
		int[] scores = {85,60,94};
		int total = 0;
		
		for(int i=0; i<scores.length;i++) {
			total+= scores[i];
		}
		System.out.println(total);
		
		//향상된 포문
		int total2 =0 ;
		for(int score : scores) {
			total2+=score;
		}
		System.out.println(total2);
		
		double avg = (double)total/scores.length;
		System.out.println(avg);
		
		scores = new int[] {80,65,94};  // 새로운(새주소) 배열 생성
		
		//값을 미리 지정하지 않는 경우 
		int[] scores2 = new int[10]; //10개의 요소를 넣을 수 있는 배열을 생성. 
		System.out.println(Arrays.toString(scores2));  //-> 기본으로 0으로 자동 초기화 되어 있음. 
		
		int age;
		ArrayEx arrex = new ArrayEx();
		System.out.println(arrex.age);
		
		//메서드 호출
		print(scores); //매개값. 
		print(new int[] {12,3,4});
		
		//다차원배열
		//2차원 -> 배열 안에 배열
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		System.out.println(matrix.length);
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(matrix[0][0]);
		
		
		//2차원 배열 모든 요소 출력
		for(int i=0; i<matrix.length ; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.println(matrix[i][j]);
			}
		}
		for(int[] m : matrix) {
			for(int m2 : m) {
				System.out.println(m2);
			}
		}
		
		System.out.println(Arrays.deepToString(matrix));
		
		//arraycopy()를 사용해서 복사하는 법
		int[] newScores = new int[3];
		System.arraycopy(scores, 0, newScores, 0, scores.length);
		System.out.println(Arrays.toString(newScores));
		
		int[] scores3 = Arrays.copyOf(scores, scores.length);
		System.out.println(Arrays.toString(scores3));
		
		
		
		
	}
	
	//메서드 선언
	public static void print(int[] arr) { //arr이 매개변수 
		System.out.println(Arrays.toString(arr));
	}

}
