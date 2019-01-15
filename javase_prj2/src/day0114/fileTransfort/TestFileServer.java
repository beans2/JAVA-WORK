package day0114.fileTransfort;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class TestFileServer extends JFrame implements Runnable, ActionListener {
	private DefaultListModel<String> dlmFileList;
	private JButton btnStartServer;

	private Thread threadServer;
	private ServerSocket socketServerFile;

	public TestFileServer() {
		super("File Server");
		// 3. ����� �ν��Ͻ� ���� ����
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<>(dlmFileList);

		btnStartServer = new JButton("���� ����");

		JScrollPane jsp = new JScrollPane(listFile);
		jsp.setBorder(new TitledBorder("���ϸ��"));

		JPanel panel = new JPanel();
		panel.add(btnStartServer);

		add("Center", jsp);
		add("South", panel);

		btnStartServer.addActionListener(this);

		setBounds(100, 100, 400, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		try {

			Socket socketClient = null;
			DataInputStream dis = null;

			StringBuilder fileName = new StringBuilder();
			int dataCnt = 0;
			File file = null;
			FileOutputStream fos = null;
			byte[] readData = null;
			// ������ ������
			try {
				while (true) {
					dis = new DataInputStream(socketClient.getInputStream()); // Ŭ���̾�Ʈ ���Ͽ� ��Ʈ�� ����

					// ���ϸ� �Է¹���
					fileName.delete(0, fileName.length()); // �ʱ�ȭ
					fileName.append(dis.readUTF()); // Ŭ���̾�Ʈ���� ���� �����͸� �޾ƿ�(���ϸ�)

					fileName.insert(fileName.lastIndexOf("."), "_".concat(String.valueOf(System.currentTimeMillis())));

					// ������� �����Ǵ� ���ϸ��� list�� ���,������ ���� Ŭ���̾�Ʈ�� ip�ּҵ� ���
					dlmFileList.addElement(fileName.toString() + " ��ó: " + socketClient.getInetAddress());

					// Ŭ���̾�Ʈ�� �����ϴ� �迭�� ������ �Է¹���
					dataCnt = dis.readInt(); // ���ڸ��� �Է¹��� ������ readInt�� ���?
					file = new File("C:/dev/workspace/javase_prj2/src/day0114/images/" + fileName);
					// ���� ��ο� ���ϸ����� ���ϰ�������ؼ� ���� ��ü����

					fos = new FileOutputStream(file); // ���� ��Ʈ�� ����
					readData = new byte[512];

				}
			} finally {
				if (fos != null) {fos.close();}
				if (dis != null) {dis.close();}
				if (socketClient != null) {socketClient.close();}
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}//run

	@Override
	public void actionPerformed(ActionEvent e) {
		if (threadServer == null) {

			try {
				socketServerFile = new ServerSocket(10000);
				dlmFileList.addElement("������ 10000��Ʈ�� �����Ǿ����ϴ�.");
				threadServer = new Thread(this);
				threadServer.start(); // ������ start()�� �ϰԵǸ� run�޼ҵ尡 ������� �����Ѵ�.

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "��Ʈ�� �̹� ��� ���Դϴ�.");
				e1.printStackTrace();
			} // �������� ����
			
		} else {
			JOptionPane.showMessageDialog(this, "������ �̹� ���� �� �Դϴ�.");
		}//end else
	}// actionPerformed

	public static void main(String[] args) {
		new TestFileServer();
	}//main
}
