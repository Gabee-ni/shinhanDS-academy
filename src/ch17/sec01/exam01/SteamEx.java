package ch17.sec01.exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SteamEx {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("신용권");
		set.add("감자바");
		
		Stream<String> stream = set.stream();
		//람다표현식 name -> accept라는 메소드의 매개변수
//		stream.forEach(name -> System.out.println(name));
		//익명구현객체
//		stream.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//			
//		});
		
		//구현클래스
//		UserClass uc = new UserClass();
//		stream.forEach(uc);
		
		//확인 (출력 <-List, Set)
		set.stream().forEach(n->System.out.println(n));
	
//		//2차원 리스트 혹은 2차원 배열의 출력은?
//		int[] amounts = {1000000, 490000, 700000, 290000};
//		int[] num = new int[2];
//		List<Integer>[] list = new ArrayList[4];
//		for(int i=0; i<amounts.length;i++) {
//			list[i] = new ArrayList<Integer>();
//		}
//		for(int i=0;i<list.length;i++) {
//			
//			list[i].add(i+3);
//		}
//		
//		
//		System.out.println(list); //객체형식
//		//flatMap으로 1차원으로 처리한 후 작업 후 forEach
//		Arrays.stream(list)
//	      .flatMap(Arrays::stream)
//	      .forEach(System.out::println);
//		
		
		
	}

}
