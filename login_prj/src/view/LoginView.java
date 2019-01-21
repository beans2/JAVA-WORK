package login.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import login.controller.LoginController;

@SuppressWarnings("serial")
public class LoginView extends JFrame{
	private JTextField jtfId;
	private JPasswordField jpfPw;
	private JButton jbLogin, jbSignUp;
	private JLabel jlForgetPass;
	
	public LoginView() {
		super("simple login");
		JLabel jlId,jlPw,jlTitle;
		setLayout(null);
		jlTitle = new JLabel("Simple Login");
		jlId = new JLabel("아이디");
		jlPw = new JLabel("비밀번호");
		jlForgetPass = new JLabel("비밀번호 찾기");
		jtfId = new JTextField();
		jpfPw = new JPasswordField();
		jbLogin = new JButton("로그인");
		jbSignUp = new JButton("회원가입");
		
		jlTitle.setBounds(190,30,200,40);
		jlTitle.setFont(new Font("Serif", Font.BOLD, 30));
		add(jlTitle);
		
		jlId.setBounds(60,100,80,25);
		add(jlId);
		
		jlPw.setBounds(60,150,100,25);
		add(jlPw);
		
		jtfId.setBounds(130,100,300,30);
		add(jtfId);
		
		jpfPw.setBounds(130,150,300,30);
		add(jpfPw);
		
		jbLogin.setBounds(130,200,300,40);
		add(jbLogin);
		
		jbSignUp.setBounds(130,250,300,40);
		add(jbSignUp);
		
		jlForgetPass.setBounds(240,300, 100,30);
		add(jlForgetPass);
		
		//이벤트
		LoginController lc = new LoginController(this);
		addWindowListener(lc);
		
		jlForgetPass.addMouseListener(lc);
		jbLogin.addActionListener(lc);
		jbSignUp.addActionListener(lc);
		
		
		setBounds(100,100,550,400);
		setResizable(false);
		setVisible(true);
		
	}//생성자

	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}

	public JButton getJbLogin() {
		return jbLogin;
	}

	public JButton getJbSignUp() {
		return jbSignUp;
	}
	
}//class
