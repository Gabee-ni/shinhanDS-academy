package ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		
		//익명구현객체로 스레드 생성
//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				
//				for(int i=0; i<5; i++) {
//					toolkit.beep();
//					//예외 처리? -> 프로그램이 중단되지 않기 위해  + unhandled exception을 해결하기 위해 try-catch로 처리하거나 throws로 떠넘기기...
//					try {
//						Thread.sleep(500); //static 메서드 -> 객체 생성 없이 클래스 이름으로 접근 가능. 
//					} catch (Exception e) {
//					}
//					
//				}
//				
//				for(int i=0; i< 5; i++) {
//					System.out.println("띵");
//					try {
//						Thread.sleep(500);
//					} catch (Exception e) {
//					}
//				}		
//			}
//		});
		
		//람다식으로 Runnable의 run 메서드 재정의 
		Thread thread = new Thread(()-> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			
			for(int i=0; i<5; i++) {
				toolkit.beep();
				//예외 처리? -> 프로그램이 중단되지 않기 위해  + unhandled exception을 해결하기 위해 try-catch로 처리하거나 throws로 떠넘기기...
				try {
					Thread.sleep(500); //static 메서드 -> 객체 생성 없이 클래스 이름으로 접근 가능. 
				} catch (Exception e) {
				}
				
			}
			
			for(int i=0; i< 5; i++) {
				System.out.println("띵");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
				}
			}		
			
		});
		
		thread.start();

//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		
//		for(int i=0; i<5; i++) {
//			toolkit.beep();
//			//예외 처리? -> 프로그램이 중단되지 않기 위해  + unhandled exception을 해결하기 위해 try-catch로 처리하거나 throws로 떠넘기기...
//			try {
//				Thread.sleep(500); //static 메서드 -> 객체 생성 없이 클래스 이름으로 접근 가능. 
//			} catch (Exception e) {
//			}
//			
//		}
//		
//		for(int i=0; i< 5; i++) {
//			System.out.println("띵");
//			try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//			}
//		}
	}

}
