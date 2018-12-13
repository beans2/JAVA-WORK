package kr.co.sist.memo.view;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.evt.MemoHelpEvt;

@SuppressWarnings("serial")
public class MemoHelp extends Dialog{
	private JavaMemo jm;
	private TextArea taHelp;
	private Button btnOk;
	public MemoHelp(JavaMemo jm){
		super(jm,"메모장 정보",true);
		this.jm = jm;
		
		taHelp = new TextArea("메모장 정보\n"+"이 메모장은 Java로 만들어졌으며 누구나 코드 수정 및 배포를 할 수 있습니다. \n"
				+ "단, 이 코드를 사용하여 개선했을 때에는 소스공개를 원칙으로 합니다. GNU\n"+"작성자: 정택성\n"+"version: 1.0");
		btnOk = new Button("확인");
		
		setLayout(null);		
		taHelp.setBounds(20,30,470,330);
		taHelp.setEditable(false);
		add(taHelp);
		btnOk.setBounds(215,360,50,30);
		add(btnOk);
		
		MemoHelpEvt mhe = new MemoHelpEvt(this);
		btnOk.addActionListener(mhe);
		
		setBounds(jm.getX()+50,jm.getY()+50,500,400);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		setVisible(true);
		
		
	}//HelpFormat
	public static void main(String[] args) {
		new JavaMemo();
	}
	public Button getBtnOk() {
		return btnOk;
	}

}
