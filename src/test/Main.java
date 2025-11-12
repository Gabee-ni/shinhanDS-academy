package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Bank bank = new Bank();
		boolean run = true;
		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine());

			// 입력한 값에 따라 처리
			if(1 == selectNo) {
				System.out.println("------------");
				System.out.println("계좌생성");
				System.out.println("------------");
				
				System.out.print("계좌번호 : ");
				String accountNum = scanner.nextLine();
				
				System.out.print("계좌주 : ");
				String accountHolder = scanner.nextLine();
				
				System.out.print("초기입금액 : ");
				int firsteDeposit = Integer.parseInt(scanner.nextLine());
				
				bank.createAccount(accountNum, accountHolder, firsteDeposit);
				
			}else if(2 == selectNo) {
				bank.accountList();
				
			}else if(3 == selectNo) {
				System.out.println("----------------");
				System.out.println("예금");
				System.out.println("----------------");
				
				System.out.print("계좌번호 : ");
				String accountNum = scanner.nextLine();
				
				System.out.print("예금액 : ");
				int money = Integer.parseInt(scanner.nextLine());
				
				bank.deposit(accountNum, money);
				
			}else if(4 == selectNo) {
				System.out.println("----------------");
				System.out.println("출금");
				System.out.println("----------------");
				
				System.out.print("계좌번호 : ");
				String accountNum = scanner.nextLine();
				
				System.out.print("출금액 : ");
				int money = Integer.parseInt(scanner.nextLine());
				
				bank.withdraw(accountNum, money);
				
			}else if(5 == selectNo) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}