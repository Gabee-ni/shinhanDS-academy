package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws IOException {
		OutputStream os = null;
		try {
			os = new FileOutputStream("D://temp//test1.db");
			
			byte a =10;
			byte b= 20;
			byte c= 30;
			
			os.write(a);
			os.write(b);
			os.write(c);
			
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();	
			} catch (Exception e2) {
			}
		}
		
	}

}
