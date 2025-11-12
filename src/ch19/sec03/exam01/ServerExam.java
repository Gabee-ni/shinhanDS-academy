package ch19.sec03.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExam {
	//static 메서드에서 사용해야 하니, 해당 필드도 static으로 지정. 
	//왜 굳이 필드로? start와 stop 메서드에서 같은 소켓을 접근해야하니까. 변수로 생성할 시 각기 다른 소켓이 되기 때문.  
	//null로 초기화 == 초기화 X (기본값이 null)
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("----------------------------");
		System.out.println("서버를 종료하려면 q또는 Q를 입력하고 Enter 키를 입력하세요");
		System.out.println("----------------------------");
		
		startServer();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")) break;
		}
		sc.close();
		
		stopServer();
	}

	public static void startServer() {
		//익명 상속 객체를 구현하고 run 오버라이딩
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					//50001번 포트에 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("서버| 시작됨");
					
					while(true) {
						//accept는 연결 요청 전까지 실행 멈췄다가 요청 들어오면 블로킹 해제되고 socket 리턴
						//socket은 클라이언트와의 연결된 통로로, 이 스트림을 통ㅇ해서 상대방에게 데이터를 전송
						System.out.println("서버| 연결 요청을 기다립니다.");
						Socket socket = serverSocket.accept();
						
						//연결된 클라이언트의 IP 주소와 port 번호를 얻기 위해 InetSocket 얻고 메서드 활용
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("서버| "+isa.getHostString()+"의 연결요청을 수락함");
						System.out.println("포트번호 : " + isa.getPort()+" IP주소 : "+isa.getHostName());
						
						//데이터 받기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();
						
						//데이터 보내기 
						//DataOutputStream은 기본 자료형을 바이트 단위로 쉽게 전송할 수 있도록 도와주는 보조스트릠 
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						message += " -서버";
						//내부적으로 문자열을 utf-8형식의 바이트로 자동변환해 전송. 
						dos.writeUTF(message);
						dos.flush();
						System.out.println("서버| 받은 데이터를 다시 보냄: "+message);
						
						
						
						
						socket.close();
						System.out.println("서버| "+isa.getHostString()+"의 연결을 끊음");
						
					}
				} catch (Exception e) {
					//실행 도중 또 실행을 하면, 해당 주소가 이미 사용중, 바인딩 되어 있다는 오류메시지 출력됨. 
					System.out.println("서버| "+e.getMessage());
				}
				
			}
		};
		thread.start();
		
	}
	
	public static void stopServer() {
		try {
			serverSocket.close();
			
			System.out.println("서버| 종료됨");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
