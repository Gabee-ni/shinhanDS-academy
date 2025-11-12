package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) {
		Writer writer = null;
		try {
			 writer = new FileWriter("D://temp//test1.text");
			
			char a = 'A';
			writer.write(a);
			
			char b = 'B';
			writer.write(b);
			
			char[] arr = {'C','D','E'};
			writer.write(arr);
			
			writer.write("FGH");
			writer.write(65);
			writer.flush();
			
		} catch (Exception e) {
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
