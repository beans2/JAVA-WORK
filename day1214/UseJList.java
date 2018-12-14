package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * MVC Pattern 을 기반으로한 Component 의 사용
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener,MouseListener/*,ListSelectionListener*/{
	
	private JList<String> jl; //View
	private DefaultListModel<String> dlm;//Model
	
	private JLabel jlOutput;
	
	private JButton jb;
	
	public UseJList() {
		super("JList 사용");
		
		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");
		
		jl=new JList<String>(dlm);
		
		//ScrollBar가 없는 JList에게 ScrollBar설정
		JScrollPane jsp = new JScrollPane(jl);
		
		
		jlOutput = new JLabel("출력");
		jlOutput.setBorder(new TitledBorder("선택아이템"));
		
		jb=new JButton("입력");
		
		add("North",jb);
		add("Center",jsp); //컴포넌트를 가진 스크롤바 객체를 배치
		add("South",jlOutput);
		
		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);
		
		setBounds(100,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}//UseJList
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String lang = JOptionPane.showInputDialog("컴퓨터 개발관련 언어 입력");
		
		//입력데이터 이므로 Model 객체를 사용한다.
//		System.out.println(lang);
		if(lang!=null&&!lang.equals("")) {
			dlm.addElement(lang);
		}//end if
		
	}//actionPerformed
//	private boolean flag;
//	@Override
//	public void valueChanged(ListSelectionEvent lse) {
//		//선택된 아이템(JList)의 값(DefaultListModel)을 얻어와서 
//		if(flag) {
//			int idx;
//			idx = jl.getSelectedIndex();
//			String value = dlm.get(idx);
//			//JLabel에 추가
//			jlOutput.setText(value);
//			//선택된 값을 삭제
//			dlm.removeElement(value);
//		}//end if
//		flag=!flag;
//	}//valueChanged //이벤트가 발생되면 메소드동작이 2번반복되어 오류가 생김

	public static void main(String[] args) {
		new UseJList();
	}//main

	@Override
	public void mouseClicked(MouseEvent e) {
		int idx;
		idx = jl.getSelectedIndex();
		String value = dlm.get(idx);
		//JLabel에 추가
		jlOutput.setText(value);
		//선택된 값을 삭제
		dlm.remove(idx);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
		
	

}//class
