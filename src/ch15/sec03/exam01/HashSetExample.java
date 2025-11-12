package ch15.sec03.exam01;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java");
		set.add("Spring");
		
		System.out.println("총 객체 수 :"+set.size());
		System.out.println(set);
		
		//향상된 for문 
		for(String s : set) {
			System.out.println(s);
		}
		System.out.println();
		
		
		//iterator 사용 
		Iterator iterator = set.iterator();
//		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
//			String e = (String) iterator.next();
//			System.out.println(e);
			
//			String e = iterator.next();
//			System.out.println(e);
			
			System.out.println(iterator.next());  //Object타입으로 반환 됨.현재(Iterator 타입 명시 X)
			//문자열은 toString은 Object의 toString을 오버라이딩하여 자기 자신의 문자열 값을 그대로 반환으로 재정의 되어 있음. 따라서 형변환이 없어도 toString이 호출되어 문자열이 출력됨. 
		}
		
		Map< String, Integer> map = new HashMap<String, Integer>();
		//var map2 = new HashMap<String, Integer>();
		
		String[] city = {"서울","부산","대전","광주","인천","대구","서울","서울","대구"};
		for(String c : city) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		System.out.println();
		System.out.println(map);
		
		//map반복
		Set<String> keys = map.keySet();
		Iterator<String> key_iter = keys.iterator();
		while(key_iter.hasNext()) {
//			String key = key_iter.next();
//			System.out.println(key);
			
			System.out.println(key_iter.next()+":"+map.get(key_iter.next())); //커서 위치에 의해서, 대전 다음 키의 값인 서울의 값을 출력//즉 현재 키 출력하고 커서가 또 이동해서 다음 키로 이동해서 그럼
		}
		
		for(String key : map.keySet()) {
			System.out.println(key+ ":"+map.get(key)); //향상된 포문으로 뽑는게 더 명확함 
		}
		
		System.out.println();
		Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();
		
		map2.put("가", 1);
		map2.put("나", 1);
		map2.put("다", 1);
		map2.put("라", 1);
		map2.put("마", 1);
		map2.put("바", 1);
		
		for(String key : map2.keySet()) {
			System.out.println(key+ ":"+map2.get(key)); //향상된 포문으로 뽑는게 더 명확함 
		}
		
		
		
		
		
		
	}

}
