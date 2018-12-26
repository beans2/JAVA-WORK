package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


/**
 * port(0~65535 �� �ϳ��� ����) �� ����, ��Ʈ�� ������ �޴� ��
 * @author owner
 */
public class SimpleServer {
	
	public SimpleServer() throws IOException {
		//1. PORT�� ���� �����ڰ� �����⸦ ��ٸ���.
		ServerSocket server=null;
		//�����ڿ��� ������ �޼���
		String msg = "��������! - ������";
		String revMsg ="";//�����ڰ� ������ �޼���
		
		//�����ڿ��� �޼����� ���������� ��Ʈ��.
		DataOutputStream dos = null;
		//�����ڰ� �������� �޼����� �б� ���� ��Ʈ��.
		DataInputStream dis = null;
		try {
			server = new ServerSocket(3000);
			System.out.println("���� ���� ��"+ server);
			//3. �����ڰ� ������ ������ ������ �޽��ϴ�.
			while(true) {
				Socket client = server.accept();
				System.out.println("������ ����: "+client);
				//4.�����ڿ��� �޼����� ���������� ��Ʈ������
				dos = new java.io.DataOutputStream(client.getOutputStream());
				//5.�� ��Ʈ���� �����;���
				dos.writeUTF(msg);
				//6.��Ʈ���� �����͸� ������(����)����
				dos.flush();				
				//12. Ŭ���̾�Ʈ�� �������� �޼����� �б����� ��Ʈ���� ����
				dis = new DataInputStream(client.getInputStream());
				//13. ��Ʈ������ �޼����б�
				revMsg = dis.readUTF();
				JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�� �޼���\n"+revMsg);
						
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
			System.err.println("��Ʈ�� �̹� ������Դϴ�");
			e.printStackTrace();
		}
	}

}
