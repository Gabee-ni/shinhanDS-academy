package ch06.sec15;

public class SingletoneExample {
	public static void main(String[] args) {
		Singletone s1 = Singletone.getSingletone();
		Singletone s2 = Singletone.getSingletone();
		
		if(s1 == s2) {
			System.out.println("같은");
		}else {
			System.out.println("다른");
		}
	}
}
