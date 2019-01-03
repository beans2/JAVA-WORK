package kr.co.sist.multichat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.multichat.server.helper.ServerHelper;
import kr.co.sist.multichat.server.view.ServerView;

public class ServerEvt extends WindowAdapter implements ActionListener{

	private ServerView sv;
	private Thread threadServer1,threadServer2,threadServer3,threadServer4;
	private ServerSocket server1,server2,server3,server4;
	private List<ServerHelper> listClient1, listClient2, listClient3, listClient4;

	public ServerEvt(ServerView sv) {
		this.sv = sv;
		listClient1 = new ArrayList<ServerHelper>();
		listClient2 = new ArrayList<ServerHelper>();
		listClient3 = new ArrayList<ServerHelper>();
		listClient4 = new ArrayList<ServerHelper>();
	}// ServerEvt

	@Override
	public void windowClosing(WindowEvent e) {
		sv.dispose();
	}// windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		try {
			if (server1 != null) {server1.close();}
			if (server2 != null) {server2.close();}
			if (server3 != null) {server3.close();}
			if (server4 != null) {server4.close();}
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}// windowClosed

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sv.getJbStart()) {
			
			if (threadServer1 == null && threadServer2 == null && threadServer3 == null && threadServer4 == null) {
				threadServer1 = new Thread() {
					@Override
					public void run() {
						try {
							server1 = new ServerSocket(11000);
						
							Socket someClient1 = null;
							
							ServerHelper sh1 = null; //모든 접속자에게 스트림을 연결하고 대화를 읽고 브로드캐스팅 역할
						
							while (true) {
								someClient1 = server1.accept();
								sh1 = new ServerHelper(someClient1, listClient1, sv, sv.getJtaChatDisplay1(), sv.getJspChatDisplay1());
								listClient1.add(sh1);
								sh1.start();
							} // end while
				
						} catch (IOException e) {
							e.printStackTrace();
						} // end catch
					}
				};
				threadServer1.start();
				sv.getJtaChatDisplay1().setText("1조 서버가동중.....");
				
				threadServer2 = new Thread() {
					@Override
					public void run() {
						try {
							server2 = new ServerSocket(12000);
							
							Socket someClient2 = null;
							
							ServerHelper sh2 = null; //모든 접속자에게 스트림을 연결하고 대화를 읽고 브로드캐스팅 역할
							
							while (true) {
								someClient2 = server2.accept();
								sh2 = new ServerHelper(someClient2, listClient2, sv, sv.getJtaChatDisplay2(), sv.getJspChatDisplay2());
								listClient2.add(sh2);
								sh2.start();
							} // end while
							
						} catch (IOException e) {
							e.printStackTrace();
						} // end catch
					}
				};
				threadServer2.start();
				sv.getJtaChatDisplay2().setText("2조 서버가동중.....");
				
				threadServer3 = new Thread() {
					@Override
					public void run() {
						try {
							server3 = new ServerSocket(13000);
							
							Socket someClient3 = null;
							
							ServerHelper sh3 = null; //모든 접속자에게 스트림을 연결하고 대화를 읽고 브로드캐스팅 역할
							
							while (true) {
								someClient3 = server3.accept();
								sh3 = new ServerHelper(someClient3, listClient3, sv, sv.getJtaChatDisplay3(), sv.getJspChatDisplay3());
								listClient3.add(sh3);
								sh3.start();
							} // end while
							
						} catch (IOException e) {
							e.printStackTrace();
						} // end catch
					}
				};
				threadServer3.start();
				sv.getJtaChatDisplay3().setText("3조 서버가동중.....");
				
				threadServer4 = new Thread() {
					@Override
					public void run() {
						try {
							server4 = new ServerSocket(14000);
							
							Socket someClient4 = null;
							
							ServerHelper sh4 = null; //모든 접속자에게 스트림을 연결하고 대화를 읽고 브로드캐스팅 역할
							
							while (true) {
								someClient4 = server4.accept();
								sh4 = new ServerHelper(someClient4, listClient4, sv, sv.getJtaChatDisplay4(), sv.getJspChatDisplay4());
								listClient4.add(sh4);
								sh4.start();
							} // end while
							
						} catch (IOException e) {
							e.printStackTrace();
						} // end catch
					}
				};
				threadServer4.start();
				sv.getJtaChatDisplay4().setText("4조 서버가동중.....");
				
			} else {
				JOptionPane.showMessageDialog(sv, "채팅서버가 이미 가동중입니다.");
			}
		} else if (ae.getSource() == sv.getJbClose()) {
			switch (JOptionPane.showConfirmDialog(sv, "채팅서버를 종료하시겠습니까?\n 종료하시면 모든 접속이 종료됩니다.")) {
			case JOptionPane.OK_OPTION: sv.dispose();
			}// end switch
		} // end if
	}// actionPerformed

}// class