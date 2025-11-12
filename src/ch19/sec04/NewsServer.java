package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewsServer {

	private static DatagramSocket datagramSocket = null;
	
	public static void main(String[] args) {

		System.out.println("-----------------------");
		System.out.println("서버를 종료하려면 q를 입력하고, Enter키를 입력하세요");
		System.out.println("-----------------------");
		
		startServer();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")) break;
			
		}
		
		sc.close();
		stopServer();
		
	}

	private static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					datagramSocket = new DatagramSocket(50001);
					System.out.println("서버| 시작됨");
					
					while(true) {
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivePacket);
						String newsKind = new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
					
						SocketAddress socketAddress = receivePacket.getSocketAddress();
						
						for(int i=1; i<=10; i++) {
							//보낼 내용을 UTF-8형식의 바이트 배열로 변환 (네트워크 전송은 바이트 단위이기 때문)
							String data = newsKind + " : 뉴스"+i;
							byte[] bytes = data.getBytes("UTF-8");
							//데이터패킷은 UDP에서 한 번에 보내는 데이터 봉투 ( 보낼 데이터, 시작 위치, 길이, 수신자의 IP와 포트번호 )
							DatagramPacket senPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
							datagramSocket.send(senPacket); //UDP소켓이 네트워크고 데이터 전송
							
						}
					}
					
				} catch (Exception e) {
					System.out.println("서버| "+e.getMessage());
				}
			}
		};
		thread.start();
	}
	
	private static void stopServer() {
		datagramSocket.close();
		System.out.println("서버| 종료됨");
	}


}
