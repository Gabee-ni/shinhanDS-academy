package ch06.problem;

import java.util.Scanner;
/*
 * 1 계좌번호 계좌주 초기입금액 입력
 * Account 객체 생성
 * 배열에 저장
 * 2 배열의 전체 계좌 출력
 * 3 계좌번호 입력 예금액 입력 해당계좌번호의 잔액 +
 * 4 계좌번호 입력 출금액 입력 해당계좌번호의 잔액 -
 * 5 프로그램 종료 
 * */
public class BankApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] ac = new Account[100];
		int idx = 0; //길이이자, 다음 인덱스를 가리키는 변수. 반복문 시, ac.length는 100개라서 null값까지 확인해야 하는데, idx까지로 범위 지정해주면 불필요한 확인 줄일 수 있음. 
		
		while(true) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 입금 | 4. 출금 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택>");
			String input = sc.nextLine();
			
			
			if("1".equals(input)) {
				System.out.print("계좌번호 : ");
				String accountNumber = sc.nextLine();
				System.out.print("계좌주 : ");
				String name = sc.nextLine();
				System.out.print("초기입금액 : ");
				int firstDeposit = Integer.parseInt(sc.nextLine());
				
				if(idx==100) {
					System.out.println("계좌목록이 꽉 찼습니다.");
					continue;
				}
				//배열에 저장할 때 
				ac[idx++] = new Account(accountNumber,name,firstDeposit);
				System.out.println("계좌가 생성되었습니다.");
				
			}else if("2".equals(input)) {
				for(int i=0; i<idx;i++) { //향상된 for문이나 ac.length를 했을 떄는 100개까지 확인하는 문제가 발생. idx로 범위 지정. 
					System.out.print(ac[i].toString());
				}
				
			}else if("3".equals(input)) {
				System.out.println("----------------");
				System.out.println("예금");
				System.out.println("----------------");
				
				System.out.print("계좌번호 : ");
				String str = sc.nextLine();
				
				System.out.print("예금액 : ");
				int money = Integer.parseInt(sc.nextLine());
				
				for(int i=0; i<idx;i++) { //전체 계좌를 찾는 것. 
					if(str.equals(ac[i].getAccountNumber())){ // 입력한 계좌번호랑 i번째의 계좌번호랑 같은지 비교하기
//						ac[i].setDeposit(money);//setBalance와 getBalance로 활용하는게 좋을지도 
						ac[i].setBalance(ac[i].getBalance() + money);
						continue;
					}
					
				} 
				
			}else if("4".equals(input)) {
				System.out.println("----------------");
				System.out.println("출금");
				System.out.println("----------------");
				
				System.out.print("계좌번호 : ");
				String str = sc.nextLine();
				
				System.out.print("출금액 : ");
				int money = Integer.parseInt(sc.nextLine());
				
				for(int i=0; i<idx;i++) {
					if(str.equals(ac[i].getAccountNumber())){
						if(ac[i].getBalance()-money < 0) {
							System.out.println("잔고가 부족합니다.");
							continue;
						}
//						ac[i].setWithDrawl(money);
						ac[i].setBalance(ac[i].getBalance() - money);
						System.out.println("출금이 성공되었습니다.");
						continue;
					}
				} 
			}else if("5".equals(input)) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
