package day1210;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Work1210_2 extends Frame{
	public Work1210_2() {
		super("수동배치");
		//////////버튼/////////////////////
		Button btn1 = new Button("확인");
		///////////라벨///////////////////
		Label lblFont = new Label("글꼴");
		Label lblFontstyle = new Label("글꼴스타일");
		Label lblFontsize = new Label("크기");
		Label lblLook= new Label("보기");
		Label tflook = new Label("AaBbYyZz");
		
		///////////텍스트필드//////////////
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		
		////////////리스트///////////////
		List listFont = new List();
		listFont.add("Dialog");
		listFont.add("Serif");
		listFont.add("SansSerig");
		listFont.add("Dialog");
		listFont.add("Dialog");
		
		List listFontstyle = new List();
		listFontstyle.add("일반");
		listFontstyle.add("굵게");
		listFontstyle.add("기울임꼴");
		listFontstyle.add("굵게 기울임꼴");
		
		List listFontsize = new List();
		int temp =0;
		for(int i=1; i<81;i++) {
			if(i<6) {
				temp=i*2;
				listFontsize.add(String.valueOf(temp));	
			}else if(i>10) {
				listFontsize.add(String.valueOf(i));				
			}
		}
		//////////////////배치관리자 설정///////////////////
		setLayout(null);
		
		///////////////////배치///////////////////////////
		lblFont.setBounds(30,80,40,30);
		add(lblFont);
		lblFontstyle.setBounds(240,80,70,30);
		add(lblFontstyle);
		lblFontsize.setBounds(450,80,40,30);
		add(lblFontsize);
		
		tf1.setBounds(30,110,80,30);
		add(tf1);
		tf2.setBounds(240,110,80,30);
		add(tf2);
		tf3.setBounds(450,110,80,30);
		add(tf3);
		
		listFont.setBounds(25,145,100,90);
		add(listFont);
		listFontstyle.setBounds(235,145,100,90);
		add(listFontstyle);
		listFontsize.setBounds(445,145,100,90);
		add(listFontsize);
		
		lblLook.setBounds(240,300,40,30);
		add(lblLook);
		tflook.setBounds(180,350,250,80);
		tflook.setFont(new Font("Dialog", Font.BOLD,50));
		add(tflook);
		
		btn1.setBounds(500,400,50,30);
		add(btn1);
		
		/////////////////윈도우 사이즈//////////////////
		setBounds(10,10,600,500);
		setResizable(false);
		setVisible(true);
		
		////////////////////닫기구현////////////////////
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			
			}//windowClosing
		});
	}
	public static void main(String[] args) {
		new Work1210_2();
	}

}
