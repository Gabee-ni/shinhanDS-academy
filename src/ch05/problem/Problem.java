package ch05.problem;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		//7 최댓값 출력
		int max = Integer.MIN_VALUE;
		int[] array = {-1, -5, -3, -8 ,-2};
		
		for(int n : array) {
			if(n> max) max = n;
		}
		System.out.println(max);
		System.out.println();
		//위 문제에는 버그가 존재. ->? 음수인 경우는 최댓값을 못찾음.  -> 따라서 Integer.MIN_VALUE 또는 MAX_VALUE활용
		
		//8 전체 합과 평균 출력
		int[][] array2 = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		int sum =0, count = 0;
	
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				sum += array2[i][j];
				count++;
			}
		}
		System.out.println("총합 : "+ sum + "\n평균: "+ (double)sum/count); //배열의 요소의 개수가 다를 수 있으니 count 변수 활용하기!!!!!
		System.out.println();
		
		//9 점수분석 프로그램
		/*아래 같이 동작 과정 생각하는 습관 들이기 
		  
		  Scanner 객체 생성
		  학생점수 배열선언
		  	
		  while 
		  	-출력
		  	1이면 
		  		-학생 수 입력
		  		-학생 수만큼 배열 초기화
		  	2이면
		  		-배열 개수만큼 반복 입력, 저장 
		  	3이면
		  		-배열 전체 출력
	  		4이면
	  			-최고점수
	  			-평균 출력 
  			5이면 종료 
		  
		 */
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true; 
		int[] scores = null; //학생 점수가 담길 배열 선언. 미리 선언하는 이유 -> while문에서는 반복되면서 선언되기 때문에 안됨.
		
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택>");
			
			String type = sc.nextLine();
			
			if("1".equals(type)) {
				System.out.print("학생수>");
				int student = Integer.parseInt(sc.nextLine());
				scores = new int[student]; //초기화				
				
			}else if("2".equals(type)) { //1번을 입력하기 전에 2번부터 입력될 경우
				if(scores==null) {
					System.out.println("학생 수를 먼저 입력하세요.");
					continue;
				}
				for(int i=0; i<scores.length; i++) {
					 try {
						 	System.out.print("scores["+i+"]>");   
						 	int score = Integer.parseInt(sc.nextLine());
						 	scores[i] = score;
						 	
				        } catch (NumberFormatException e) {
				            System.out.println("숫자가 아닌 값을 입력하셨습니다. 정수를 입력해주세요.");
				            continue;
				        }
				}
				
			}else if("3".equals(type)) {
				if(scores==null) {
					System.out.println("점수 입력을 먼저 해주세요.");
					continue;
				}
				
				for(int i=0; i<scores.length; i++) {
					System.out.print("scores["+i+"]>"+scores[i]);
					System.out.println();
					
				}
			}else if("4".equals(type)) {
				if(scores==null) {
					System.out.println("점수 입력을 먼저 해주세요.");
					continue;
				}
				
				int maxScore = Integer.MIN_VALUE; 
				int totalScore = 0;
				
				for(int n : scores) {
					if(n> maxScore) {
						maxScore = n;
					}
					totalScore += n;
				}
				
				System.out.println("최고점수 : "+ maxScore);
				System.out.println("평균점수 : "+ (double)totalScore/scores.length);
	
			}else if("5".equals(type)) {
				System.out.println("프로그램 종료");
				run = false;
			}

		}//while문

	}

}
