package test;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Bank {
	private List<Account> accountList = new ArrayList<Account>();
	
	
	// 계좌생성 
	public void createAccount(String accountNum, String accountHolder, int money) {
//		for(Account a : accountList) {
//			if(accountNum.equals(a.getAccountNum())){
//				System.out.println("결과 : 이미 등록된 계좌입니다.");
//				return;
//			}
//		}
		if(findAccount(accountNum)==null) {
			accountList.add(new Account(accountNum, accountHolder, money));
			System.out.println("결과 : 계좌가 생성되었습니다.");
		}else {
			System.out.println("결과 : 이미 등록된 계좌입니다.");
		}
	}
	
	// 계좌목록출력
	public void accountList() {
		for(Account a : accountList) {
			System.out.println(a.getAccountNum()+"\t"+a.getAccountHolder()+"\t"+a.getBalance());
		}
	}
	
	// 예금하기
	public void deposit(String accountNum , int money) {
		if(findAccount(accountNum)==null) {
			System.out.println("일치하는 계좌가 없습니다.");
			return;
		}
		
		Account a = findAccount(accountNum);
		if(accountNum.equals(a.getAccountNum())) {
			a.setBalance(a.getBalance()+money);
			System.out.println("결과 : 예금이 성공되었습니다.");
		}
	}
	
	// 출금하기
	public void withdraw(String accountNum, int money) {
		if(findAccount(accountNum)==null) {
			System.out.println("일치하는 계좌가 없습니다.");
			return;
		}
		
		Account a = findAccount(accountNum);
		if(accountNum.equals(a.getAccountNum())) {
			a.setBalance(a.getBalance()-money);
			System.out.println("결과 : 출금이 성공되었습니다.");
		}
	}
	
	// 매개변수(계좌번호)와 동일한 Account 객체 찾기
	private Account findAccount(String ano) {
		for(Account a : accountList) {
			if(ano.equals(a.getAccountNum())){
				return a;
			}
		}
		return null;
		
	}
}
