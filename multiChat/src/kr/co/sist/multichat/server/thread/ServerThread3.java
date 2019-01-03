package kr.co.sist.multichat.server.thread;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.multichat.server.helper.ServerHelper;
import kr.co.sist.multichat.server.view.ServerView;

public class ServerThread3 implements Runnable{

	private ServerView sv;
	private ServerSocket server;
	private List<ServerHelper> listClient;
	private Thread threadServer;
	
	public ServerThread3() {
		if (threadServer == null) {
			threadServer = new Thread(this);
			threadServer.start();
			sv.getJtaChatDisplay1().setText("서버가동중.....");
		} else {
			JOptionPane.showMessageDialog(sv, "채팅서버가 이미 가동중입니다.");
		}
	}
	@Override
	public void run() {
		try {
			server = new ServerSocket(10000);
		
			Socket someClient = null;
			
			ServerHelper sh = null; //모든 접속자에게 스트림을 연결하고 대화를 읽고 브로드캐스팅 역할
		
			while (true) {
				someClient = server.accept();
				sh = new ServerHelper(someClient, listClient, sv, sv.getJtaChatDisplay3(), sv.getJspChatDisplay3());
				listClient.add(sh);
				sh.start();
			} // end while

		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// run

}