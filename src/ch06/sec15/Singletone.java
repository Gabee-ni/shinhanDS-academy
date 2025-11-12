package ch06.sec15;

public class Singletone {
	private static Singletone singletone = new Singletone();
//	private static Singletone singletone = null; -> 이 방식을 왜 안 씀?? : 
	// 싱글톤 패턴을 기능적인 것을 구현할 때는 ㄱㅊ, 
	//VO같은 것은 객체가 여러개가 존재함. 따라서 데이터를 저장하거나 여러개 다루는 객체를 싱글톤으로 생성하면 안됨.
	
	
	private Singletone() {
		
	}
	
	public static Singletone getSingletone() {
//		if(singletone == null) {
//			return new Singletone() 
//		}
		return singletone;
	}
}
