package day0108;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PreparedStatementLogin extends JFrame{

	private JTextField jtfId;
	private JPasswordField jptPass;
	private JButton jbtLogin;
	private JButton jbtCancel;
	
	public PreparedStatementLogin() {
		super("Statement 객체를 사용한 로그인");
		jtfId = new JTextField();
		jptPass = new JPasswordField();
		jbtLogin = new JButton("로그인");
		jbtCancel = new JButton("취소");
		
		setLayout(new GridLayout(3,1));
		JPanel pannel = new  JPanel();
		pannel.add(jbtLogin);
		pannel.add(jbtCancel);
		
		jtfId.setBorder(new TitledBorder("아이디"));
		jptPass.setBorder(new TitledBorder("비밀번호"));		
		
		add(jtfId);
		add(jptPass);
		add(pannel);
		
		PreparedStatementLoginEvt sle = new PreparedStatementLoginEvt(this);
		jtfId.addActionListener(sle);
		jptPass.addActionListener(sle);
		jbtLogin.addActionListener(sle);
		jbtCancel.addActionListener(sle);
		
		addWindowListener(sle);
		
		setBounds(100,100,300,180);
		setVisible(true);
		setResizable(false);
			
	}//StatementLogin
	
	
	public JTextField getJtfId() {
		return jtfId;
	}


	public JPasswordField getJptPass() {
		return jptPass;
	}


	public JButton getJbtLogin() {
		return jbtLogin;
	}


	public JButton getJbtCancel() {
		return jbtCancel;
	}


	public static void main(String[] args) {
		new PreparedStatementLogin();
	}//main
}
