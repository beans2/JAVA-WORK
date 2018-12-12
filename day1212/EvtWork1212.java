package day1212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class EvtWork1212 implements ActionListener,ItemListener{
	private DesignWork1212 dw;

//	private String list;
	public EvtWork1212(DesignWork1212 dw) { //has a �۾�
		this.dw = dw;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// �߰�/����/����/�ݱ� ��ư�� �����ٸ�

		if (ae.getSource() == dw.getBtnAdd()) { //�߰���ư�� ������ ��
//			if (!(dw.getTfName().getText().isEmpty()) || !(dw.getTfAge().getText().isEmpty())
//					|| !(dw.getTfAddr().getText().isEmpty())) {
			if (!(dw.getTfName().getText().equals("")) || !(dw.getTfAge().getText().equals(""))  //�����Է��� �ƴ϶��
					|| !(dw.getTfAddr().getText().equals(""))) {
				add(); //�߰��۾�
			}
		}
		if (ae.getSource() == dw.getBtnDel()) { //������ư�� ������ ��
			delete(); //�����۾�
		}
		if (ae.getSource() == dw.getBtnAlt()) { //�����ư�� ������ ��
			alter(); //�����۾�
		}
		if (ae.getSource() == dw.getBtnCls()) { //�ݱ��ư�� ������ ��
			close();//�ݱ��۾�
		}
	}//actionPerformed
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		listselect();
	}
	
	private void listselect() { //����Ʈ�� ���õǾ��� �� �޼ҵ�
		String info = dw.getList().getSelectedItem();
		String[] naa = info.toString().split("/");
		dw.getTfName().setText(naa[0]);
		dw.getTfAge().setText(naa[1]);
		dw.getTfAddr().setText(naa[2]);
		
	}

	private void add() {//�߰��޼ҵ�

		StringBuilder list = new StringBuilder();
		list.append(dw.getTfName().getText()).append("/").append(dw.getTfAge().getText()).append("/")
				.append(dw.getTfAddr().getText());
		dw.getList().add(list.toString());
		dw.getTfName().setText("");
		dw.getTfAge().setText("");
		dw.getTfAddr().setText("");
	}


	private void delete() {//�����޼ҵ�
//		List list = dw.getList();
		String info = dw.getList().getSelectedItem();
		dw.getList().remove(info);
	}

	private void alter() {//����޼ҵ�
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
	}

	private void close() {//�ݱ�޼ҵ�
		dw.dispose();
	}

	

//	private void 

}
