package ch12.sec03.exam01;

public class Member {
	public String id;
	
	public Member() {
		
	}
	
	public Member(String id) {
		this.id = id;
	}
	
	//어떤 객체가 들어올지 몰라서 매개변수를 최상위부모 Object로 받은 것
	public boolean equals(Object obj) {
		//단, 그 변수가 Member 타입(target변수) 이면 조건 실행 
		if(obj instanceof Member target) {
			//현재 객체에 있는 id (즉, this.id)
			if(id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
}
