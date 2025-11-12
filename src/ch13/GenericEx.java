package ch13;

import java.util.ArrayList;
import java.util.List;

import ch12.sec03.exam05.Member;

public class GenericEx {

	public static void main(String[] args) {

//		List list = new ArrayList();
//		list.add(1);
//		list.add(3.14);
//		list.add(new Member());
//		
////		System.out.println(list );
//		
//		for(int i=0; i<list.size();i++) {
//			System.out.println(list.get(i));
////			System.out.println(((Member) list.get(i)).getName());
//		
//		}
		
		List<Member> list = new ArrayList<Member>(); //Member 객체만 담을 수 있는 리스트 -> 지정 안 할 때는 Object -> Member로 지정  
		list.add(new Member());
		
		for(int i=0; i<list.size();i++) {
			System.out.println(((Member) list.get(i)).getName());
		
		}
		
//		List<Integer> list2 = new ArrayList<>();
//		list2.add(1);
//		System.out.println(list2.get(0).intValue());
//		
		List list2 = new ArrayList();
		list2.add(1);
		System.out.println(((Integer) list2.get(0)).intValue()); //int는 타입 파라미터의 대체타입이 될 수 없고 Object타입인 Integer로 작성해야함.
		
		
	}

}
