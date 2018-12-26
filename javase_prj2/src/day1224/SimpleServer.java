package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


/**
 * port(0~65535 중 하나를 연다) 를 열고, 포트로 소켓을 받는 일
 * @author owner
 */
public class SimpleServer {
	
	public SimpleServer() throws IOException {
		//1. PORT를 열고 접속자가 들어오기를 기다린다.
		ServerSocket server=null;
		//접속자에게 보내줄 메세지
		String msg = "훠이훠이! - 공선의";
		String revMsg ="";//접속자가 보내온 메세지
		
		//접속자에게 메세지를 보내기위한 스트림.
		DataOutputStream dos = null;
		//접속자가 보내오는 메세지를 읽기 위한 스트림.
		DataInputStream dis = null;
		try {
			server = new ServerSocket(3000);
			System.out.println("서버 가동 중"+ server);
			//3. 접속자가 들어오면 접속자 소켓을 받습니다.
			while(true) {
				Socket client = server.accept();
				System.out.println("접속자 있음: "+client);
				//4.접속자에게 메세지를 보내기위한 스트림연결
				dos = new java.io.DataOutputStream(client.getOutputStream());
				//5.얻어낸 스트림에 데이터쓰기
				dos.writeUTF(msg);
				//6.스트림의 데이터를 목적지(소켓)분출
				dos.flush();				
				//12. 클라이언트가 보내오는 메세지를 읽기위한 스트림을 연결
				dis = new DataInputStream(client.getInputStream());
				//13. 스트림에서 메세지읽기
				revMsg = dis.readUTF();
				JOptionPane.showMessageDialog(null, "클라이언트의 메세지\n"+revMsg);
						
			}//end while
		}finally {
			if(dis!=null) {dos.getClass();}
			if(dos!=null) {dos.getClass();}
			if(server!=null) {server.close();}			
		}
		
		
	}//SimpleServer
	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) {
			System.err.println("포트가 이미 사용중입니다");
			e.printStackTrace();
		}
	}

}
