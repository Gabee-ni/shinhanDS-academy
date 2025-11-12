package ch18.sec04.exam02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("D://temp//test1.text");
			//문자로 
//			while(true) {
//				int data = reader.read();
//				if(data == -1)break;
//				System.out.print((char)data);
//			}
			int data =0;
			while((data = reader.read())!= -1) {
				System.out.print((char)data);
			}
			
			reader.close();
			System.out.println();
			
			reader = new FileReader("D://temp//test1.text");

			//문자 배열로 
			char[] data2 = new char[100];
			int cnt =0;
			while((cnt = reader.read(data2))!= -1) {
				for(int i=0 ;i <cnt;i++) {
					System.out.print(data2[i]);
				}
			}
			
			
		} catch (Exception e) {
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
