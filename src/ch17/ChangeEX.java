package ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeEX {

	public static void main(String[] args) {
		/*
		 배열 <-> 리스트 
		 */
		
		int[] arr1 = {1,2,3};
		//리스트로 변환
		//1. for문으로 변환
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr1.length;i++) {
				list.add(arr1[i]);
		}
		
		System.out.println(list);
		
		//2. stream으로 리스트 변환 
		List<Integer> list2 = Arrays.asList(  //List로 변환
								Arrays.stream(arr1).boxed() //boxed로 wrapper 타입으로 바꾸고
								.toArray(Integer[]::new) //매개변수 생략..? Integer[]으로 변환 
			); 
		System.out.println(list2.get(1));
		
		//리스트에서 int[] 배열로 변환 
		//1. stream과 람다식으로 변환 
		int[] arr2 = {};
//		arr2 = list.stream().mapToInt(Integer::intValue).toArray();

		//mapInTo( (i): 매개 변수 -> (i) : 리턴 결과)
		arr2 = list.stream().mapToInt(i->i).toArray();
		System.out.println(Arrays.toString(arr2));
		
		//2. for문으로 배열로 변환
		int[] arr3 = new int[list.size()];
		for(int i=0; i< arr3.length;i++) {
			arr3[i] = list.get(i);
		}
		System.out.println(Arrays.toString(arr3));
		
		
		//문자열 (참조자료형) -> 리스트 변환 asList
		String[] arr4 = {"김길동","박길동","홍길동"};
		List<String> list3 = Arrays.asList(
				Arrays.stream(arr4).toArray(String[]::new));
		//리스트 -> 문자열 변환 toArray
		String[] arr5 = list3.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(arr5));
		
	}

}
