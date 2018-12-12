package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class CutFriendDesign extends Frame{
	private List list1;
	private List list2;
	private Button butten1;
	private Button butten2;
	
	public CutFriendDesign() {
		Label label1 =new Label("친구목록");
		Label label2 = new Label("차단된친구");

		list1 = new List();
		String[] friends = {"이재찬","이재현","정택성"};
		for(int i=0; i<friends.length;i++) {
			list1.add(friends[i]);
		}
		
		list2 = new List();
		
		butten1 = new Button(">>");
		butten2 = new Button("<<");
		/////////////////////////////////////////////////////////////
		setLayout(null);
		
		label1.setBounds(50,50,60,20);
		add(label1);
		label2.setBounds(230,50,70,20);
		add(label2);
		list1.setBounds(50,80,60,200);
		add(list1);
		list2.setBounds(235,80,60,200);
		add(list2);
		butten1.setBounds(150,110,40,40);
		add(butten1);
		butten2.setBounds(150,200,40,40);
		add(butten2);
		
		/////////////////////////////////////////////////////////////
		
		setBounds(30,40,400,300);
		//////////////////////////////////////////////////////////////
		setResizable(false);
		setVisible(true);
		/////////////////////////////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}//CutFriendDesign
	
	
	
	
	
	
	public static void main(String[] args) {
		new CutFriendDesign();
	}

}
