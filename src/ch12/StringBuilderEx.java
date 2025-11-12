package ch12;

import java.util.ArrayList;
import java.util.List;

public class StringBuilderEx {

	public static void main(String[] args) {

//		//String은 immutable하기에 조작이 불가능함. 따라서 아래와 같이 +연산을 하면 다른 객체로 생성됨.
//		String name = "홍길동";
//		System.out.println(name.hashCode());
//		
//		name += "님";
//		System.out.println(name.hashCode());
//		
//		//StringBuilder는 한 객체 안에서 조작이 가능함. 
//		StringBuilder sb = new StringBuilder();
//		sb.append("홍길동");
//		System.out.println(sb.hashCode());
//		
//		sb.append("님");
//		System.out.println(sb.hashCode());
		
//		long start = System.currentTimeMillis();
//		String str = "";
//		for(int i=0 ; i<100000;i++ ) {
//			str += i;
//		}
//		
//		long end = System.currentTimeMillis();
//		System.out.println("소요시간 :"+(end-start));
//		
		long start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<100000;i++ ) {
			sb.append(i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("소요시간 :"+(end-start));
		
		
		int a = 10;
		List list = new ArrayList();
		list.add(a);  //int -> 박싱 -> Integer (자동형변환)
		
		Integer  b = a;//boxing
		int c = b; //unboxing
		
		Long d  = 30L;
		int e = d.intValue();
	
		
		//소수점 두자리에서 반올림
		
		//소수점 두자리로 반올림 -> 3자리에서. 그러나 자바는 자릿수를 지정해주는 메서드가 없기에 정수로 계산해야함.
		//두자리(2) - > 10의 3승, 세자리(3) -> 10의 4승 
		double f = 1.1235;
		double temp = f*100;
		System.out.println(Math.round(f*100)/100.0); // round는 소숫점 자리 상관없이 정수로 반올림 해버림. 
		
		
		
		
	}

}
