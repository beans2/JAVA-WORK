package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import login.controller.SignUpController;

public class SignUpView extends JDialog{
	
	private JTextField jtfId, jtfTel1, jtfTel2, jtfTel3,
		jtfEmail1, jtfEmail2, jtfSsn1, jtfSsn2, jtfZipcode,
		jtfAddrBunji, jtfAddress,jtfAddMore, jtfQes,jtfAns,jtfName;
	private JPasswordField jpfPw1, jpfPw2;
	private JButton jbAddress,jbSignUp, jbCancel ,jbIdVerification,jbSsnVerification;
	private JComboBox<String> jcbEmail, jcbQus;
	
	
	public SignUpView(LoginView lv) {
		super(lv,"sign up",true);
		
		setLayout(null);
		JLabel jlTitle, jlId,jlPw1,jlPw2,jlTel,jlEmail,jlSsn,
		jlAddress1,jlAddress2, jlVal, jlAnswer,jlhypen1,jlhypen2,jlhypen3,jlgolbeng,jlName;
		
		jlTitle = new JLabel("회원가입");
		jlId = new JLabel("아이디");
		jlPw1 = new JLabel("비밀번호");
		jlPw2 = new JLabel("비밀번호 확인");
		jlTel = new JLabel("핸드폰");
		jlEmail= new JLabel("이메일");
		jlSsn= new JLabel("주민등록번호");
		jlAddress1 = new JLabel("주소");
		jlAddress2 = new JLabel("상세 주소"); 
		jlVal = new JLabel("인증 질문"); 
		jlAnswer = new JLabel("질문 답");
		jlhypen1 = new JLabel("-");
		jlhypen2 = new JLabel("-");
		jlhypen3 = new JLabel("-");
		jlgolbeng = new JLabel("@");
		jlName = new JLabel("이름");
		
		jtfId = new JTextField(); 
		jtfTel1 = new JTextField(); 
		jtfTel2 = new JTextField();
		jtfTel3 = new JTextField();
		jtfEmail1 = new JTextField(); 
		jtfEmail2 = new JTextField(); 
		jtfSsn1 = new JTextField(); 
		jtfSsn2 = new JTextField(); 
		jtfZipcode = new JTextField();
		jtfAddrBunji = new JTextField(); 
		jtfAddress = new JTextField();
		jtfQes = new JTextField();
		jtfAns = new JTextField();
		jtfAddMore = new JTextField();
		jtfName = new JTextField();
		
		jpfPw1 = new JPasswordField();
		jpfPw2 = new JPasswordField();
		
		jbAddress = new JButton("주소 검색");
		jbSignUp = new JButton("회원가입");
		jbCancel = new JButton("취소");
		jbIdVerification = new JButton("중복확인");
		jbSsnVerification = new JButton("인증");
		
		jcbEmail = new JComboBox<String>() ;
		jcbQus = new JComboBox<String>();
		
		jlTitle.setBounds(180,10,200,50);
		jlTitle.setFont(new Font("Dialog", Font.BOLD, 30));
		add(jlTitle);
		
		jlId.setBounds(50,60,80,30);
		add(jlId);
		jlPw1.setBounds(50,100,80,30);
		add(jlPw1);
		jlPw2.setBounds(50,140,100,30);
		add(jlPw2);
		jlName.setBounds(50,180,100,30);
		add(jlName);
		jlTel.setBounds(50,220,80,30);
		add(jlTel);
		jlEmail.setBounds(50,260,80,30);
		add(jlEmail);
		jlSsn.setBounds(50,300,80,30);
		add(jlSsn);
		jlAddress1.setBounds(50,340,80,30);
		add(jlAddress1);
		jlAddress2.setBounds(50,420,80,30);
		add(jlAddress2);
		jlVal.setBounds(50,460,80,30);
		add(jlVal);
		jlAnswer.setBounds(50,500,80,30);
		add(jlAnswer);
		jlhypen1.setBounds(220,220,20,25);
		add(jlhypen1);
		jlhypen2.setBounds(320,220,20,25);
		add(jlhypen2);
		jlhypen3.setBounds(232,300,20,25);
		add(jlhypen3);
		jlgolbeng.setBounds(220,260,20,25);
		add(jlgolbeng);
		
		jtfId.setBounds(140,60,170,30);
		add(jtfId);
		jpfPw1.setBounds(140,100,270,30);
		add(jpfPw1);
		jpfPw2.setBounds(140,140,270,30);
		add(jpfPw2);
		jtfName.setBounds(140,180,270,30);
		add(jtfName);
		jtfTel1.setBounds(140,220,70,30);
		add(jtfTel1);
		jtfTel2.setBounds(240,220,70,30);
		add(jtfTel2);
		jtfTel3.setBounds(340,220,70,30);
		add(jtfTel3);
		jtfEmail1.setBounds(140,260,80,30);
		add(jtfEmail1);
		jtfEmail2.setBounds(240,260,80,30);
		add(jtfEmail2);		
		jtfSsn1.setBounds(140,300,90,30);
		add(jtfSsn1);
		jtfSsn2.setBounds(240,300,100,30);
		add(jtfSsn2);
		jtfAddrBunji.setBounds(140,340,140,30);
		jtfAddrBunji.setEditable(false);
		jtfAddrBunji.setBackground(Color.white);
		add(jtfAddrBunji);
		jtfAddress.setBounds(140,380,270,30);
		jtfAddress.setEditable(false);
		jtfAddress.setBackground(Color.white);
		add(jtfAddress);
		jtfAddMore.setBounds(140,420,270,30);
		add(jtfAddMore);
		jtfAns.setBounds(140,500,270,30);
		add(jtfAns);
		
		jbAddress.setBounds(290,340,120,30);
		add(jbAddress);
		jbSignUp.setBounds(190,560,100,30);
		add(jbSignUp);
		jbCancel.setBounds(310,560,100,30);
		add(jbCancel);
		jbIdVerification.setBounds(320,60,90,30);
		add(jbIdVerification);
		jbSsnVerification.setBounds(350,300,60,30);
		add(jbSsnVerification);
		//jbAddress,jbSignUp, jbCancel
		
		jcbEmail.setBounds(330,260,80,30);
		jcbEmail.addItem("직접입력");
		jcbEmail.addItem("NAVER");
		jcbEmail.addItem("DAUM");
		jcbEmail.addItem("GOOGLE");
		add(jcbEmail);
		
		jcbQus.setBounds(140,460,270,30);
		jcbQus.addItem("질문을 선택해주세요.");
		jcbQus.addItem("자신의 인생 좌우명은?");
		jcbQus.addItem("자신의 보물 제 1호는?");
		jcbQus.addItem("기억에 남는 추억의 장소는?");
		jcbQus.addItem("내가 좋아하는 캐릭터는?");
		add(jcbQus);
		
		///이벤트
		SignUpController suc = new SignUpController(lv, this);
		addWindowListener(suc);
		jbAddress.addActionListener(suc);
		jbIdVerification.addActionListener(suc);
		jbCancel.addActionListener(suc);
		jbSignUp.addActionListener(suc);
		jbSsnVerification.addActionListener(suc);
		jcbEmail.addItemListener(suc);
		
		
		setBounds(lv.getX()+50,lv.getY()+50,480,670);
		setVisible(true);
		setResizable(false);
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JTextField getJtfTel1() {
		return jtfTel1;
	}

	public JTextField getJtfTel2() {
		return jtfTel2;
	}

	public JTextField getJtfTel3() {
		return jtfTel3;
	}

	public JTextField getJtfEmail1() {
		return jtfEmail1;
	}

	public JTextField getJtfEmail2() {
		return jtfEmail2;
	}

	public JTextField getJtfSsn1() {
		return jtfSsn1;
	}

	public JTextField getJtfSsn2() {
		return jtfSsn2;
	}

	public JTextField getJtfZipcode() {
		return jtfZipcode;
	}

	public JTextField getJtfAddrBunji() {
		return jtfAddrBunji;
	}

	public JTextField getJtfAddress() {
		return jtfAddress;
	}

	public JTextField getJtfAddMore() {
		return jtfAddMore;
	}

	public JTextField getJtfQes() {
		return jtfQes;
	}

	public JTextField getJtfAns() {
		return jtfAns;
	}

	public JPasswordField getJpfPw1() {
		return jpfPw1;
	}

	public JPasswordField getJpfPw2() {
		return jpfPw2;
	}

	public JButton getJbAddress() {
		return jbAddress;
	}

	public JButton getJbSignUp() {
		return jbSignUp;
	}

	public JButton getJbCancel() {
		return jbCancel;
	}

	public JComboBox<String> getJcbEmail() {
		return jcbEmail;
	}

	public JComboBox<String> getJcbQus() {
		return jcbQus;
	}

	public JButton getJbIdVerification() {
		return jbIdVerification;
	}

	public JButton getJbSsnVerification() {
		return jbSsnVerification;
	}

	public JTextField getJtfName() {
		return jtfName;
	}
	
	
}
