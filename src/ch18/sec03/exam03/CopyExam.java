package ch18.sec03.exam03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class CopyExam {

	public static void main(String[] args) throws IOException {

		String originalFileName = "D:/temp/test2.png";
		String targetFileName = "D:/temp/test3.png";
		
		InputStream is = new FileInputStream(originalFileName);
		OutputStream os = new FileOutputStream(targetFileName);
		
		byte[] data = new byte[1024];
		
		while(true) {
			int num = is.read(data);
			if(num==-1) break;
			os.write(data,0,num); //읽은 바이트 수 만큼 출력 -> 따라서 num이 없으면 바로 while 종료해야 함. 
		}
		
		os.flush();
		os.close();
		os.close();
		
		System.out.println("복사가 잘 되었습니다.");
		
	}

}
