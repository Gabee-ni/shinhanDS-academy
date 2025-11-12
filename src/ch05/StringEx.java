package ch05;

import java.util.Arrays;

public class StringEx {

	public static void main(String[] args) {
		//String은 immutable
		//추출
		String msg = "안녕하세요.";
		char a = msg.charAt(0);
		
		System.out.println(a);
		
		//대체
		String msg2 = msg.replace("안", "녕");
		System.out.println(msg2); //immutable하기에 msg는 새로운 객체이지, msg가 변경된 것이 아니다. 
		
		//길이 응용
		for(int i=0; i<msg.length();i++) {
			System.out.println(msg.charAt(i));
		}
		
		//부분문자열 -> 메서드 오버로딩 : 인자값이 다르고 이름이 같은 메소드. 
		System.out.println(msg.substring(0,2)); // 0부터 n-1까지 잘라냄. 
		System.out.println(msg.substring(2));//n~끝
		
		//찾기 -> 특정 단어의 포함여부에 주로 사용. 
		System.out.println(msg.indexOf("하"));
		//특정단어 포함 여부
		if(msg.indexOf("욕") > -1) {
			//포함되어 있는 부분
		}
		//특정 단어로 시작하는지 여부
		if(msg.startsWith("안녕"));System.out.println("맞");
		
		//특정 문자로 분리하기 -> String[]
		//예) csv : Comma Seperate Value
		String csv = "홍길동,이순신,강감찬,유관순";
		String[] csvArr = csv.split(",");
		
//		for(String str : csvArr) System.out.println(str);
		System.out.println(Arrays.toString(csvArr));
		
		//공백제거
		String address = "   서울시    마포구    서교동 1234";
		System.out.println(address.strip()); 			//좌우 공백 제거
		System.out.println(address.replace(" ", "")); 	//모든 공백 제거
		
		
		//퀴즈
		//파일 업로드 시 문제
		//1. 파일명 중복
		//2. 한글파일명 
		// -> 파일명을 임의의 값으로 변경해서 저장해야 함. ex) 내사진.jpg -> 서버에는 123.jpg로 저장됨.
		// 해당 이름은 커랜트타임밀리즈를 사용
		System.out.println(System.currentTimeMillis()); //이것도 동시 업로드 시 중복될 수도 있음 ->실무에서는 나노타임 사용 
		System.out.println();
		
		String fileName = "2025.10.25.내.사진.jpg";
		String fileNameInServer = fileName.replace(fileName.substring(0, fileName.indexOf (".")), System.currentTimeMillis()+"");
		System.out.println("파일명 : "+fileName + "\n서버저장 파일명 : "+fileNameInServer);
		
		//강사님 방식 
		//.의 인덱스에서부터 시작해서 뒤에 확장자만 구해서 새로 구한 값에 확장자만 더해줌. 
		//그런데 .이 파일명 내에 존재한다면? -> 나중에 나오는 .의 인덱스를 가지고 와야 함. => 
		System.out.println(System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf(".")));		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
