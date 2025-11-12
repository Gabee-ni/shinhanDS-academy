package ch19.sec02;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.URL;

public class InetAddressExam {

	public static void main(String[] args) {

		try {
			
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 주소 : "+local);
			
			//네이버 도메인 이름에 여러 IP주소 존재. -> 로드밸런싱을 위해서
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP 주소 : "+remote.getHostAddress());
			}
			
			String url = "https://www.egovframe.go.kr/home/sub.do?menuNo=2";
			URL urlObj = new URL(url);
			System.out.println(urlObj.getProtocol()); //프로토콜
			System.out.println(urlObj.getQuery());  //?뒤에 있는 쿼리 스트링 (파라미터)
			
			//해당 url의 페이지의 데이터를 읽어와서 출력 (바이트 기반)
			InputStream is = urlObj.openStream(); 
//			Reader reader = new InputStreamReader(is); //보조스트림 (바이트 기반 -> 텍스트 기반) 
//			
//			int count =0;
//			while((count=reader.read()) != -1 ) {
//				System.out.print((char)count);
//			}
			
			//보조스트림(성능향상) -> 버퍼로 
//			BufferedReader br = new BufferedReader(is);//reader객체가 인자값으로 들어와야 함.//여기에 바이트 기반을 넣어서 텍스트 기반으로 변경 
			BufferedReader br = new BufferedReader(new InputStreamReader(urlObj.openStream())); //보편적 작성법
			
			String line = "";
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
