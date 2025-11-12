package ch06.problem;

public class Account {
	
	private String accountNumber;
	private String name;
	private int balance;
	
	public Account() {
		
	} 
	public Account(String accountNumber, String name, int firstDeposit) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = firstDeposit;
	} 
// 되도록이면 VO에서 연산하지 않도록 
//	public void setDeposit(int num ) {
//		this.balance += num;
//		
//	}
//	public void setWithDrawl(int num) {
//		this.balance -= num;
//	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}
	public String getName() {
		return this.name;
	}
	public int getBalance() {
		return this.balance;
	}
	@Override
	public String toString() {
		return accountNumber + "\t" + name +  "\t"  + balance +"\n";
	}
}
