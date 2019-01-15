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
		// 3. 사용할 인스턴스 변수 생성
		dlmFileList = new DefaultListModel<String>();
		JList<String> listFile = new JList<>(dlmFileList);

		btnStartServer = new JButton("서버 가동");

		JScrollPane jsp = new JScrollPane(listFile);
		jsp.setBorder(new TitledBorder("파일목록"));

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
			// 쓰레드 가동시
			try {
				while (true) {
					dis = new DataInputStream(socketClient.getInputStream()); // 클라이언트 소켓에 스트림 연결

					// 파일명 입력받음
					fileName.delete(0, fileName.length()); // 초기화
					fileName.append(dis.readUTF()); // 클라이언트에서 보낸 데이터를 받아옴(파일명)

					fileName.insert(fileName.lastIndexOf("."), "_".concat(String.valueOf(System.currentTimeMillis())));

					// 만들어준 구변되는 파일명을 list에 출력,파일을 보낸 클라이언트의 ip주소도 출력
					dlmFileList.addElement(fileName.toString() + " 출처: " + socketClient.getInetAddress());

					// 클라이언트가 전송하는 배열의 갯수를 입력받음
					dataCnt = dis.readInt(); // 숫자만을 입력받을 때에는 readInt를 사용?
					file = new File("C:/dev/workspace/javase_prj2/src/day0114/images/" + fileName);
					// 위의 경로에 파일명으로 파일경로지정해서 파일 객체생성

					fos = new FileOutputStream(file); // 파일 스트림 생성
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
				dlmFileList.addElement("서버가 10000포트로 생성되었습니다.");
				threadServer = new Thread(this);
				threadServer.start(); // 쓰레드 start()를 하게되면 run메소드가 쓰레드로 동작한다.

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "포트가 이미 사용 중입니다.");
				e1.printStackTrace();
			} // 서버소켓 생성
			
		} else {
			JOptionPane.showMessageDialog(this, "서버가 이미 동작 중 입니다.");
		}//end else
	}// actionPerformed

	public static void main(String[] args) {
		new TestFileServer();
	}//main
}
