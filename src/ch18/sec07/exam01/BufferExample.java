package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = null;
		FileOutputStream fos= null;
		
		FileInputStream fis2 = null;
		FileOutputStream fos2 = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos= null; 
		try {
			//~.class.getResource = 해당 객체를 별도로 생성하지 않고 메타정보 가져오는 것. 
			String originalFilePath = BufferExample.class.getResource("org.png").getPath();
			String targetFilePath = "D:/temp/target.png";
			
			//비버퍼 스트림
			fis = new FileInputStream(originalFilePath);
			fos = new FileOutputStream(targetFilePath);
			
			String originalFilePath2 = BufferExample.class.getResource("org.png").getPath();
			String targetFilePath2 = "D:/temp/target2.png";
			
			//버퍼 스트림 
			fis2 = new FileInputStream(originalFilePath);
			fos2 = new FileOutputStream(targetFilePath);
			
			bis = new BufferedInputStream(fis2);
			bos = new BufferedOutputStream(fos2);
			
			
			long nonBufferTime = copy(fis,fos);
			System.out.println(nonBufferTime);
			
			long bufferTime = copy(bis, bos);
			System.out.println(bufferTime);
			
			
		} catch (Exception e) {
		}finally {
			bos.close();
			bis.close(); //fis2, fos2는 bis,bos를 닫을 때 내부적으로 자동 닫힘. 닫는 순서는 여는 순서 역순임. 
			fos.close();
			fis.close();
		}
		

	}
	
	//copy는 단지 복사 기능만 수행하는 유틸 메서드, 따라서 자원을 닫는 책임은 main에 있음. 
	
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();
		int data = 0;
		while((data = is.read())!=-1) {
			os.write(data);
		}
		
		os.flush();
		long end = System.nanoTime();
		return end -start;
	}
	
	
	
	
	
	
	
	
	
	
	

}
