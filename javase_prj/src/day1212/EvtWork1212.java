package day1212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EvtWork1212 implements ActionListener,ItemListener,KeyListener{
	private DesignWork1212 dw;

//	private String list;
	public EvtWork1212(DesignWork1212 dw) { //has a 작업
		this.dw = dw;
	}
	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
		int inputkey = ke.getKeyCode();
		if(inputkey==KeyEvent.VK_ENTER) {
			add();
		}
		if(inputkey==KeyEvent.VK_ESCAPE) {
			close();
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 추가/삭제/변경/닫기 버튼이 눌린다면

		if (ae.getSource() == dw.getBtnAdd()) { //추가버튼이 눌렸을 때
			if (!(dw.getTfName().getText().isEmpty()) || !(dw.getTfAge().getText().isEmpty())
					|| !(dw.getTfAddr().getText().isEmpty())) {
//			if (!(dw.getTfName().getText().equals("")) || !(dw.getTfAge().getText().equals(""))  //공백입력이 아니라면
//					|| !(dw.getTfAddr().getText().equals(""))) {
				add(); //추가작업
			}
		}
		if (ae.getSource() == dw.getBtnDel()) { //삭제버튼이 눌렸을 때
			delete(); //삭제작업
		}
		if (ae.getSource() == dw.getBtnAlt()) { //변경버튼이 눌렸을 때
			alter(); //변경작업
		}
		if (ae.getSource() == dw.getBtnCls()) { //닫기버튼이 눌렸을 때
			close();//닫기작업
		}
	}//actionPerformed
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		listselect();
	}
	
	private void listselect() { //리스트가 선택되었을 때 메소드
		String info = dw.getList().getSelectedItem();
		String[] naa = info.toString().split("/");
		dw.getTfName().setText(naa[0]);
		dw.getTfAge().setText(naa[1]);
		dw.getTfAddr().setText(naa[2]);
		
	}

	private void add() {//추가메소드

		StringBuilder list = new StringBuilder();
		list.append(dw.getTfName().getText()).append("/").append(dw.getTfAge().getText()).append("/")
				.append(dw.getTfAddr().getText());
		dw.getList().add(list.toString());
		dw.getTfName().setText("");
		dw.getTfAge().setText("");
		dw.getTfAddr().setText("");
		dw.getTfName().requestFocus();
//		return;
	}


	private void delete() {//삭제메소드
//		List list = dw.getList();
		String info = dw.getList().getSelectedItem();
		dw.getList().remove(info);
		dw.getTfName().setText("");
		dw.getTfAge().setText("");
		dw.getTfAddr().setText("");
		
	}

	private void alter() {//변경메소드
		StringBuilder str = new StringBuilder();
		str.append(dw.getTfName().getText()).append("/").append(dw.getTfAge().getText()).append("/")
				.append(dw.getTfAddr().getText());
		int info = dw.getList().getSelectedIndex();
//		dw.getList().add(str.toString(), info);
		dw.getList().remove(info);
		dw.getList().add(str.toString(), info);
		dw.getTfName().setText("");
		dw.getTfAge().setText("");
		dw.getTfAddr().setText("");
		dw.getTfName().requestFocus();
//		return;
	}

	private void close() {//닫기메소드
		dw.dispose();
	}
////	@Override
////	public void focusGained(FocusEvent fe) {
////		
////	}
////	@Override
////	public void focusLost(FocusEvent fe) { //전부 입력되면 포커스이동
////		if(dw.getTfAddr().getText().equals("")) {
////			dw.getTfName().requestFocus();			
////		}
////	}
//
//
//	
//
////	private void 

}
