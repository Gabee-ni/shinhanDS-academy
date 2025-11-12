package ch12.sec03.exam05;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data -> stackoverflow 생길 수도 있으니 비추 
@Getter @Setter 
public class Member {

	private String id;
	private String name;
	private int age;
	
	public String getName() {
		return name+"님"; //내가 정의하면 정의한 것이 실행. 
	}
}
