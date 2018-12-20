package day1211;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
	
public class ListTest extends Frame implements ItemListener{
//	private Panel panel ;
	private List listName ;
	private Label nameAge;
	public ListTest() {
		super("List");
		////////////label////////////////
//		Label nameAge = new Label("�̸�:   "+"����:   ");
		
//		panel.setSize(100,100);
//		listName.setSize(100,100);
		listName = new List();
		nameAge = new Label();
		listName.add("������ /27");
		listName.add("���ü�/26");
		listName.add("������/27");
		
//		panel.add(listName);
		setLayout(new BorderLayout());
		add("Center",listName);
		add("South",nameAge);
		
		listName.addItemListener(this);
		
		setVisible(true);
		setSize(300, 200);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ae) {
				dispose();
			}
		});
		
	}
	public static void main(String[] args) {
		new ListTest();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String[] listCut = listName.getSelectedItem().split("/");
		String name = listCut[0];
		String age =  listCut[1];
		StringBuilder sb = new StringBuilder();
		sb.append("�̸�:     ").append(name).append("     ����: ").append(age);
		nameAge.setText(sb.toString());
		
	}
}
