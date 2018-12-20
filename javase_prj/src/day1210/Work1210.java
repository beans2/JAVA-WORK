package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial") 
public class Work1210 extends Frame{

	public Work1210() {
		super("자동배치");
		//////////////컴포넌트////////////////
		Label lblNorth = new Label("학생관리"); //학생관리
		Label lnlGender = new Label("성별"); 
		Label lnlName = new Label("이름"); 
		Label lnlAge = new Label("나이"); 
		Label lnlTel = new Label("전화번호"); 
		
		/////////////버튼////////////////////
		Button lnlAdd = new Button("추가");
		Button lnlAlt = new Button("변경");
		Button lnlDel = new Button("삭제");
		Button lnlEnd = new Button("종료");
		/////////////체크박스////////////////
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox gender1= new Checkbox("남", true,cg);
		Checkbox gender2= new Checkbox("여", false,cg);
		////////////텍스트박스/////////////
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		///////////////택스트 에리어////////////
			TextArea centerEast = new TextArea();
		///////////////패널/////////////////
		Panel northPanal = new Panel(); //north panel
		northPanal.add(lblNorth);
		
		Panel genderPanal = new Panel(); //성별 Panel
		genderPanal.add(gender1);
		genderPanal.add(gender2);
		
//////////////////가운데 왼쪽 패널/////////////////////////		
		Panel centerPanal = new Panel(); //center west panel
		centerPanal.setLayout(new GridLayout(4, 2));
		centerPanal.add(lnlName);
		centerPanal.add(tf1);
		centerPanal.add(lnlAge);
		centerPanal.add(tf2);
		centerPanal.add(lnlTel);
		centerPanal.add(tf3);	
		centerPanal.add(lnlGender);
		centerPanal.add(genderPanal);

///////////////가운데 패널///////////////////////////
		Panel cp = new Panel(); //center pannel
		cp.setLayout(new GridLayout(1, 2));
		cp.add(centerPanal);
		cp.add(centerEast);
				
		Panel southPanel = new Panel(); //south Panel
		southPanel.add(lnlAdd);
		southPanel.add(lnlAlt);
		southPanel.add(lnlDel);
		southPanel.add(lnlEnd);
		
		///////////////////레이아웃에 넣기//////////////////////////
		setLayout(new BorderLayout());
		add("North",northPanal);
		add("Center",cp);
		add("South",southPanel);
		setVisible(true);
		setSize(400, 200);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
				
			}//windowClosing
		});
	}
	public static void main(String[] args) {
		new Work1210();
	}

}
