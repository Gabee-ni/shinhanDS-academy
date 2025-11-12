package ch15;

import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortEx {

	public static void main(String[] args) {
		/*		
	 	배열 : Arrays.sort(); -> 시간 복잡도 O(nlogn), 최악O(n^2)
	 	컬렉션 : Collections.sort() -> 시간 복잡도 O(nlogn);	
	 	
	 	기본자료형 : Arrays.sort(변수)
	 	참조자료형 : Arrays.sort(변수, Comparator 객체)
	 	
		 */
		
		//배열
		int[] arr = {8,1,6,2,4};
		Arrays.sort(arr);//오름차순
		System.out.println(Arrays.toString(arr));
		
		//문자열 배열 
		String[] arr2 = {"서울","부산","대전","광주","울산"};
		Arrays.sort(arr2); //오름차순
		System.out.println(Arrays.toString(arr2));
		
		
		//Arrays.sort()는 내림차순이 안됨. 기본이 오름차순 
		//내림차순 정렬
		Arrays.sort(arr2, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr2));
		
		//참조형은 내림 차순 가능. 
		Integer[] arr3 = {8,1,6,2,4};
		Arrays.sort(arr3,  Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr3));
		
		//기본자료형은 Comparator로 내림차순을 사용하지 못함.
//		Arrays.sort(arr,Comparator.reverseOrder());  
		//이는 stream으로 처리하면 됨. Arrays.stream(Array이름).boxed() <-박싱 .sorted(Comparator.reverseOrder) .mapToInt(Integer::intValue).toArray()
		//즉, 기본 자료형을 참조 자료형으로 박싱하고 컴퍼레이터 내림차순 활용하고 다시 기본 자료형으로 언 박싱
		
		
		//배열 보다는 리스트로(참조자료형으로) 문제를 풀이하는 게 훨 편리함. 
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(1);
		list.add(6);
		list.add(2);
		list.add(4);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);
		
		
		/*
		 객체 정렬 
		 	- Comparable 인터페이스를 구현하기 
		 	- Comparator 인터페이스 구현객체 (익명구현객체 override로 재정의, 람다식)  
		 */
		//커스텀 정렬
		//리스트 안에 맵객체가 들어 있다면,
		//Map<이름, 나이> (나이순으로 정렬)
		List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("name","홍길동");
		map.put("age", 20);
		list2.add(map);
		
		map = new HashMap<String, Object>(); //새 객체를 생성 안하면, map의 name이라는 키에 계속 값이 push
		map.put("name","홍길동1");
		map.put("age", 10);
		list2.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name","홍길동2");
		map.put("age", 40);
		list2.add(map);
		
		System.out.println(list2);
	
		
		Collections.sort(list2, new Comparator<Map>() {

			@Override
			public int compare(Map o1, Map o2) {
				//오름차순 
				return (int)o1.get("age") - (int)o2.get("age"); //Comparator의 반환타입이 int여서 그럼. 
				//내림차순 
//				return (int)o2.get("age") - (int)o1.get("age");
			}
		
		});
		
		System.out.println(list2);
		
		Collections.sort(list2, (a,b)-> {
//			return (int)a.get("age") - (int)b.get("age");
//			return (int)b.get("age") - (int)a.get("age");
//			return (int)b.get("name") - (int)a.get("name"); //문자열 비교는 -> compart.To()를 활용해야함. 
			return ((String) b.get("name")).compareTo((String) a.get("name"));
		});
		System.out.println(list2);
		
		
		//2차원 배열 정렬 문제 
//		int[][] arr4 = {
//				{1,99}, {2,98}, {3,97}, {4,96}
//		};
//		
//		//두번째 값 기준으로 오름차순 -> 리스트로 안 바꾸고 그냥 Comparator의 파라미터만 int[]로 하면 되는 것이었듬;
//		List<Integer> list3 = new ArrayList<>(); 
//		for(int i=0; i< arr4.length ; i++) {
//			for(int j=0; j<arr4[i].length;j++) {
//				list3.add(i, arr4[i][j]);
//			}
//			
//		}
//		
//		System.out.println(list3);
//		Collections.sort(list3, (a,b)-> {
//			return b-a;
//		});
//		System.out.println(list3);	
		

		
		//2차원 배열 정렬 답
		int[][] arr4 = {
				{1,99}, {2,98}, {3,97}, {4,96}
		};
		
		//이차원 배열이라 그냥 Arrays.sort 해도 되는 거였,,
		Arrays.sort(arr4, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		
		});
		
		System.out.println(Arrays.deepToString(arr4));
		
		//위를 람다식으로 표현 (Comparator가 추상메서드 단 1개만 존재하는 함수적 인터페이스이므로 람다식 사용 가능.)
		Arrays.sort(arr4,(o1,o2)->{
			return o1[1] - o2[1];
		});
		
		System.out.println();
		System.out.println(Arrays.deepToString(arr4));
		
		test(()->{
			
		});
		
		//이게 되는 이유는 Runnable 인터페이스도 함수형인터페이스여서 람다식 사용 가능.
		Thread t = new Thread(()->{
			//여기 재정의
		});
		
	}
	static void test(Xinterface x) {
		x.test();
	}

}
