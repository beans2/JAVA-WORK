package kr.co.sist.chat.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 * �������� �����ϸ� ������ ���Ͽ� ��Ʈ���� ���ͼ� �����ϴ� Ŭ����.<br>
 * �����ڰ� �����ϸ� ������ ���Ͽ� �� ��Ʈ������ �޼����� ���ѷ����� �о���̰� ��� �����ڿ��� �޼����� ���
 * 
 * @author owner
 */
public class MultiChatServerHelper extends Thread {
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<MultiChatServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;
	
	
	/**
	 * ������ ������ �޾Ƽ� ��Ʈ���� ��� �޼����� �аų� ���� �� �ִ� ���·� �����.
	 * 
	 * @param socket �����ڼ���
	 * @param dlm    ������ ����â�� ����ϱ� ���� Model��ü
	 * @param cnt    ���� ����
	 */
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt, JFrame jf,
			List<MultiChatServerHelper> list, JScrollPane jsp) {
		someClient = socket;
		this.dlm = dlm;
		this.cnt = cnt;
		this.jf = jf;
		connectList = list;
		this.jsp = jsp;
		

		// ��Ʈ�����
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());
			
			//�����ڰ� �������� nick�� �޴´�.
			nick = readStream.readUTF();
			//����â�� ���Ӹ޼����� ���
			dlm.addElement("["+someClient.getInetAddress()+"/"+nick+"]���� �����ϼ̽��ϴ�.");
			
			
			// ������ ������ �����ڿ��� �޼����� ���
			broadcast("[ " + cnt + "] ��° �����ڰ� ["+nick+"]���� ä�ù濡 �����Ͽ����ϴ�.");
			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
			
		} catch (IOException ie) {
			JOptionPane.showInputDialog(jf, "������ ���� �� ���� �߻�....");
			ie.printStackTrace();
		} // end catch

	}// MultiChatServerHelper

	@Override
	public void run() {
		if (readStream != null) {
			try {
				String revMsg = "";
				while (true) { // �������� �������� ��� �޼����� �о, ��� �����ڿ��� �Ѹ���.
					revMsg = readStream.readUTF();
					broadcast(revMsg);
				} // end while
			} catch (IOException ie) {
				//�����ڰ� ����ϸ� �ش� �����ڸ� ����Ʈ���� �����Ѵ�.
				connectList.remove(this);
				//�޼����� �о������ ���ϴ� ���¶�� �����ڰ� ������ ������ ����
				dlm.addElement(cnt+"��°/"+nick+" ������ ���.");
				broadcast("["+nick+"] ���� ����Ͽ����ϴ�.");
				
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				
				ie.printStackTrace();
			}//end catch
		} // end if

	}// run

	/**
	 * ��� �����ڿ��� �޼����� �ѷ��ִ� ��. synchronized : MultiThread���� ����ȣ�� ����(����ȭó��)
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public synchronized void broadcast(String msg) {
		MultiChatServerHelper mcsh = null;
		for (int i = 0; i < connectList.size(); i++) {
			mcsh = connectList.get(i);// list���� Helper��ü�� ���
			try {
				mcsh.writeStream.writeUTF(msg);// ��� ��Ʈ���� ���
				mcsh.writeStream.flush();// �������� ����
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(jf, "[" + cnt + "] ��° �����ڿ��� �޼����� ���� �� �����ϴ�.");
				ie.printStackTrace();
			} // end catch
		}
	}// broadcast
}// class