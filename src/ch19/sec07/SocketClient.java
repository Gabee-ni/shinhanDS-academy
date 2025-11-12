package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.sound.midi.Receiver;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SocketClient {
	//필드
	  ChatServer chatServer;
	  Socket socket;
	  DataInputStream dis;
	  DataOutputStream dos; 
	  String clientIp;
	  String chatName;
	
	
	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			receive();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public  void receive() {
		ChatServer.threadPool.execute(()->{
			try {
				while(true) {
					String receiveJson = dis.readUTF();
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");
					
					if("incoming".equals(command)) {
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "들어오셨습니다.");
						chatServer.addSocketClient(this);
					}else if("message".equals(command)) {
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						
					}
				}
				
			} catch (Exception e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}
	
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close() {
		try {
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



}
