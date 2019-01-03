package kr.co.sist.multichat.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.co.sist.multichat.server.view.ServerView;

public class ServerHelper extends Thread {
	
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private List<ServerHelper> connectList;
	private String nick;
	private JScrollPane jsp1;
	private JTextArea jta1;
	private JFrame jf;
	private StringBuffer sb = new StringBuffer();
	public ServerHelper(Socket socket, List<ServerHelper> list,JFrame jf, JTextArea jta ,JScrollPane jsp) {	
		someClient =socket;
		connectList = list;
		this.jf = jf;
		this.jsp1 = jsp;
		this.jta1 = jta;

		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
		
			nick = readStream.readUTF();
			sb.append("["+nick+"]���� �����ϼ̽��ϴ�.\n");
			
			jta1.setText(sb.toString());
			
			broadcast("["+nick+"] �Բ��� ä�ù濡 �����ϼ̽��ϴ�.");
			jsp1.getVerticalScrollBar().setValue(jsp1.getVerticalScrollBar().getMaximum());
	
		} catch (IOException ie) {
			JOptionPane.showInputDialog(jf,"������ ���Ṯ���߻�..");
		}
	}
	public void run() {
		if(readStream!=null) {
			try {
				String revMsg ="";
				while(true) {
					revMsg = readStream.readUTF();
					broadcast(revMsg);
				}//end while
			}catch(IOException ie) {
				connectList.remove(this);
				jta1.setText("["+nick+"]������ ���.");
				broadcast("["+nick+"]���� ����Ͽ����ϴ�.");
				
				jsp1.getVerticalScrollBar().setValue(jsp1.getVerticalScrollBar().getMaximum());
				ie.printStackTrace();
			}//end catch
		}//end if
	}//run
	public synchronized void broadcast(String msg) {
		ServerHelper sh = null;
		for (int i = 0; i < connectList.size(); i++) {
			sh = connectList.get(i);// list���� Helper��ü�� ���
			try {
				sh.writeStream.writeUTF(msg);// ��� ��Ʈ���� ���
				sh.writeStream.flush();// �������� ����
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(jf, "[" + nick + "] �����ڿ��� �޼����� ���� �� �����ϴ�.");
				ie.printStackTrace();
			} // end catch
		}
	}// broadcast
	
}







