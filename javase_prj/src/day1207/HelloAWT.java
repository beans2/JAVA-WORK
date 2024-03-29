package day1207;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Window Application 작성
 * @author owner
 */
//1. Window Component 상속
@SuppressWarnings("serial")
public class HelloAWT extends Frame{
	public HelloAWT() {
		super("AWT 연습입니다");
		//2. 사용할 일반컴포넌트 생성
		Label lblTitle = new Label("오늘 베스트 사자성어");
		TextArea ta = new TextArea("정택성씨\n구로 1동의 자랑!!!");
		
		//3. 배치관리자를 사용하여 컴포넌트를 배치
		add("North",lblTitle);
		add("Center",ta);
		
		//4.윈도우 크기 설정
		setSize(400, 270);
		//5. 사용자에게 보여주기
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				//현재 윈도우 인스턴스만 종료
				dispose();
//				System.exit(0);
			}//windowClosing
		});
		
	}//HelloAWT
	public static void main(String[] args) {
		new HelloAWT();
	}//main

}//class
