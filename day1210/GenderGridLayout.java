package day1210;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GenderGridLayout extends Frame {
	public GenderGridLayout() {
		Label lnlGender = new Label("����"); 
		
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox gender1= new Checkbox("��", true,cg);
		Checkbox gender2= new Checkbox("��", false,cg);
		setLayout(new GridLayout(1, 2));
		Panel genderPanal = new Panel(); //���� Panel
		genderPanal.add(gender1);
		genderPanal.add(gender2);
		add(lnlGender);
		add(genderPanal);
		
		setVisible(true);
		setSize(400, 400);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
				
			}//windowClosing
		});
	}
}
