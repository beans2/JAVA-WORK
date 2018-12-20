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
		super("�ڵ���ġ");
		//////////////������Ʈ////////////////
		Label lblNorth = new Label("�л�����"); //�л�����
		Label lnlGender = new Label("����"); 
		Label lnlName = new Label("�̸�"); 
		Label lnlAge = new Label("����"); 
		Label lnlTel = new Label("��ȭ��ȣ"); 
		
		/////////////��ư////////////////////
		Button lnlAdd = new Button("�߰�");
		Button lnlAlt = new Button("����");
		Button lnlDel = new Button("����");
		Button lnlEnd = new Button("����");
		/////////////üũ�ڽ�////////////////
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox gender1= new Checkbox("��", true,cg);
		Checkbox gender2= new Checkbox("��", false,cg);
		////////////�ؽ�Ʈ�ڽ�/////////////
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		///////////////�ý�Ʈ ������////////////
			TextArea centerEast = new TextArea();
		///////////////�г�/////////////////
		Panel northPanal = new Panel(); //north panel
		northPanal.add(lblNorth);
		
		Panel genderPanal = new Panel(); //���� Panel
		genderPanal.add(gender1);
		genderPanal.add(gender2);
		
//////////////////��� ���� �г�/////////////////////////		
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

///////////////��� �г�///////////////////////////
		Panel cp = new Panel(); //center pannel
		cp.setLayout(new GridLayout(1, 2));
		cp.add(centerPanal);
		cp.add(centerEast);
				
		Panel southPanel = new Panel(); //south Panel
		southPanel.add(lnlAdd);
		southPanel.add(lnlAlt);
		southPanel.add(lnlDel);
		southPanel.add(lnlEnd);
		
		///////////////////���̾ƿ��� �ֱ�//////////////////////////
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
