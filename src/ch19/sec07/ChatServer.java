package ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {

	static //필드
	ServerSocket serverSocket = null; 
	static ExecutorService threadPool = Executors.newFixedThreadPool(100);
	//멀티 스레드 환경에서 해시 맵을 안전하게 사용하기 위한 방법. 동기화된 래퍼로 감싸서 모든 접근에 락을 걸어줌. 
	static Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());
	
	//서버 시작
	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("서버| 시작됨");
	
		Thread thread = new Thread(()->{
			try {
				while(true) {
					Socket socket = serverSocket.accept();
					SocketClient sc = new SocketClient(this, socket);

				}
				
			} catch (Exception e) {
//				e.printStackTrace();
			}
		});
		thread.start();
	}
	
	//클라이언트 연결 시 SocketClient 생성 및 추가 
	public static void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "0"+ socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: "+key);
		System.out.println("현재 채팅자 수 : "+chatRoom.size()+"\n");		
		
	}
	
	//클라이언트 종료 시 socket client 제거 
	public  static void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "0"+ socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("나감: "+key);
		System.out.println("현재 채팅자 수 : "+chatRoom.size()+"\n");	
		
	}
	
	//모든 클라이언트들에게 메시지 보냄 
	public static void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();
		
		Collection<SocketClient> socketClients = chatRoom.values();
		for(SocketClient sc : socketClients) {
			if(sc== sender) continue;
			sc.send(json);
		}
	}
	
	//종료
	public static void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			chatRoom.values().stream().forEach(sc-> sc.close());
			System.out.println("서버| 종료됨 ");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		try {
			ChatServer chatServer = new ChatServer();
			chatServer.start();
			
			System.out.println("-----------------------");
			System.out.println("서버를 종료하려면 q를 입력하고, Enter키를 입력하세요");
			System.out.println("-----------------------");
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				String key = sc.nextLine();
				if(key.equals("q")) break;
			}
			sc.close();
			ChatServer.stop();
			
		} catch (Exception e) {
			System.out.println("서버 | "+e.getMessage());
		}
	}

}
