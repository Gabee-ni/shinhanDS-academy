package test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	//계좌번호, 계좌주, 잔액 필드
	//get set
	private String accountNum ;
	private String accountHolder;
	private int balance;
	
}
