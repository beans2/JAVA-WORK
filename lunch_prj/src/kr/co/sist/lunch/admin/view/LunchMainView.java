package kr.co.sist.lunch.admin.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LunchMainView extends JFrame{
	public LunchMainView(String adminName) {
		super("도시락 관리 [ 로그인 계정 : "+adminName+"]");
		
		
		
		setBounds(100,100,800,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//LunchMainView
}//class
