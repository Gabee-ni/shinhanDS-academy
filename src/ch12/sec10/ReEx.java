package ch12.sec10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReEx {

	public static void main(String[] args) {

//		boolean result = Pattern.matches("b[a-z]*", "bat");
//		boolean result = Pattern.matches("b[a-z]", "bz");
//		
//		System.out.println(result);

		
		//위 방식은 너무 느려서 아예 컴파일에 정규식을 담아서 확인하는 방식이 빠름. 
		Pattern p = Pattern.compile("b[a-z]*");
		
		Matcher m = p.matcher("bat");
		System.out.println(m.matches());
		System.out.println(p.matcher("cat").matches());
		
		//전화번호 추출
		String source = "안녕하세요 저는 홍길동인데요, 제 전화번호는 010-1234-5678입니다. 계좌번호는 3333-14-1653048, 그런데요 제 친구 번호는 02-555-7777";
		
		p = Pattern.compile("0\\d{1,2}-\\d{3,4}-\\d{4}");
		m = p.matcher(source);
		System.out.println(m.matches());

		//찾는법
		while(m.find()) {
			System.out.println(m.group());
		}
		
	}

}
