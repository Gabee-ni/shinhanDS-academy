package ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadExample {

	public static void main(String[] args){
		InputStream is  = null;
		try {
			is = new FileInputStream("D://temp//test1.db"); //FileInputStream은 인풋스트림의 자식 객체 
			
//			while(true) {
//				int data = is.read();
//				if(data==-1) break;
//				System.out.println(data);
//			}
			
//			int data=0;
//			//데이터라 더 있으며 출력하고 끝나면 조건에 안 맞아서 종료
//			while ((data=is.read()) != -1) {
//				System.out.println(data);
//			}
			
			//버퍼처럼 한 번에 읽어오기. 100개의 공간이 있는 버퍼  
			byte[] data = new byte[100];
//			while (true) {
//				int num = is.read(data);
//				if(num == -1) break;
//				
//				for(int i=0; i<num;i++) {
//					System.out.println(data[i]);
//				}
//			}
//	
			int count = 0; //현재 몇개 읽었는지 확인하기 위해 필요한 변수 
			while((count =is.read(data)) != -1) {
				
				for(int i=0; i<count;i++) {
					System.out.println(data[i]);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
				
			} catch (Exception e2) {
			}
		}
	}

}
