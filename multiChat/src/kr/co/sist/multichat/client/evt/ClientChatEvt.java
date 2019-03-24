package kr.co.sist.multichat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import kr.co.sist.multichat.client.view.ClientChatView;
import kr.co.sist.multichat.client.view.ClientSelectTeamView;
import kr.co.sist.multichat.client.view.ClientSelectUserView;

public class ClientChatEvt extends WindowAdapter implements ActionListener, Runnable {
	private ClientChatView ccv;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private Thread threadMsg;
	private String nick;
	private ClientSelectTeamView cstv;
	private ClientSelectTeamEvt cste;
	private Set<String> nickList;
	

	public ClientChatEvt(ClientChatView ccv) {		
		this.ccv = ccv;
	}// ClientChatEvt

	@Override
	public void run() {
		if (readStream != null) {
			try {
				String revMsg = "";
				String nick = "";
				JScrollPane jsp = ccv.getJsp();	
				nickList= new HashSet<String>();
				while (true) {
					revMsg = readStream.readUTF();
					nickList.add(revMsg.substring(revMsg.lastIndexOf("%%") + 2));
					System.out.println(nickList);
					
//					ccv.getJtaChatDisplay().append(revMsg/*.substring(0,revMsg.lastIndexOf("%"))+"\n"*/);
					ccv.getJtaChatDisplay().append(revMsg.substring(0, revMsg.lastIndexOf("%%")) + "\n");
					
					
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} // end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(ccv, "서버가 종료되었습니다.");
				e.printStackTrace();
			} // end catch
		} // end if
	}// run

	@Override
	public void windowClosing(WindowEvent e) {
		ccv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		try {
			if (readStream != null) {
				readStream.close();
			}
			if (writeStream != null) {
				writeStream.close();
			}
			if (client != null) {
				client.close();
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			System.exit(0);
		} // end fianlly
	}// windowClosed

	private void connectToServer() throws UnknownHostException, IOException {
		if (client == null) {
			nick = ccv.getJtfNick().getText().trim();
			
			if (nick.equals("")) {
				JOptionPane.showMessageDialog(ccv, "대화명을 입력하세요.");
				ccv.getJtfNick().requestFocus();
				return;
			} // end if
			System.out.println(ccv.getSelectTeam());
			client = new Socket("localhost", ccv.getSelectTeam());				
			readStream = new DataInputStream(client.getInputStream());
			writeStream = new DataOutputStream(client.getOutputStream());

			// 닉네임 보내기
			writeStream.writeUTF(nick);
			writeStream.flush();
			
			

			ccv.getJtaChatDisplay().setText("서버에 접속하였습니다\n");
			threadMsg = new Thread(this);
			threadMsg.start();
		} else {
			JOptionPane.showMessageDialog(ccv, client.getInetAddress().getHostAddress() + "서버에 이미 접속해있습니다.");
		} // end else
	}// connectToServer

	private void sendMsg() throws IOException {
		if(writeStream!=null) {
			JTextField jtf = ccv.getJtfTalk();
			String msg = jtf.getText().trim();
			
			if(!msg.isEmpty()) {
				writeStream.writeUTF("["+nick+"]"+msg);
				writeStream.flush();
			}//end if
			jtf.setText("");
		}//end if
	}//sendMsg

	private void capture() throws IOException {
		switch(JOptionPane.showConfirmDialog(ccv, "대화내용을 저장 하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			File saveDir = new File("c:/dev/chat");
			saveDir.mkdirs();
			File saveFile = new File(saveDir.getAbsolutePath()+"/java+chat["
					+System.currentTimeMillis()+"].dat");
			BufferedWriter bw=null;
			try {
				bw = new BufferedWriter(new FileWriter(saveFile));
				bw.write(ccv.getJtaChatDisplay().getText());
				bw.flush();
				JOptionPane.showMessageDialog(ccv, saveDir+"에 대화내용이 기록되었습니다.");
			} finally {
				if(bw!=null) {bw.close();}
			}
		}//end switch
	}//capture
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ccv.getJbConnect()) {
				try {
					connectToServer();
				} catch (UnknownHostException uhe) {
					JOptionPane.showMessageDialog(ccv, "서버를 알 수 없습니다.");
					uhe.printStackTrace();
				} catch (IOException ie) {
					JOptionPane.showMessageDialog(ccv, "연결실패");
					ie.printStackTrace();
				}
		}
		if (ae.getSource() == ccv.getJbCapture()) {
				try {
					if(!ccv.getJtaChatDisplay().getText().equals("")) {
					capture();
					}else {
						JOptionPane.showMessageDialog(ccv, "저장할 파일이 없습니다.");
					}//end else
				} catch (IOException e) {
					JOptionPane.showMessageDialog(ccv, "파일로 저장하는 중 문제가 발생하였습니다.");
					e.printStackTrace();
				}//end catch
		}
		if (ae.getSource() == ccv.getJbClose()) {
			ccv.dispose();
		}
		if (ae.getSource() == ccv.getJbUser()) {
			new ClientSelectUserView(ccv);
		}
		if(ae.getSource() == ccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(ccv,
						"서버가 종료되어 메세지를 전송할 수 없습니다.");
				ie.printStackTrace();
			}//end catch
		}//end if
	}
	public Set<String> getNickList() {
		return nickList;
	}

}