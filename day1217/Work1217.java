package day1217;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class Work1217 extends JFrame {
	private String selectMenu;
	private String inputData;
	private ArrayList<String> list = new ArrayList<String>();
	private JTextArea jta;
	private JScrollPane jsp;
	private int count = 1;
	private StringBuffer s;

	public Work1217() {

			jta = new JTextArea(10, 40);
			jta.setEditable(false);
			jta.append("��ȣ �̸� �ڹ� ����Ŭ ���� ���\n");
		while(true) {
			selectDialog();
			if (selectMenu.equals("1".trim())) {
				inputDialog();
				
			} else if (selectMenu.equals("2".trim())) {
				if (list.isEmpty()) {
					outputNotDataMessage();
				} else {
					showList();
					
				}
			} else if (selectMenu.equals("3".trim())) {
				break;
			} else {
				JOptionPane.showMessageDialog(this, "�߸��Է��ϼ̽��ϴ�");
			}
		}		
	}//end while

	public void selectDialog() { // �޴����� ���̾�α� â
		selectMenu = JOptionPane.showInputDialog("�޴�����\n 1.�Է� 2.��� 3.����");
	}

	public void inputDialog() { // �����Է� ���̾�α� â

		inputData = JOptionPane.showInputDialog("�������Է� \n ��)�̸�, �ڹ�����, ����Ŭ����");
		String[] check = inputData.split(",");
		if (check.length != 3) {
			JOptionPane.showMessageDialog(this, "�Էµ������� ���´� \n��ȣ,�̸�,�ּ�,�̸��� �̾�� �մϴ�.", "�Է¿���",
					JOptionPane.ERROR_MESSAGE);
			return;
		} // end if
		inputToList();
	}

	public void outputNotDataMessage() { // ������ ���� �޽��� ���̾�α� â
		JOptionPane.showMessageDialog(null, "�����Ͱ� �����ϴ�");
	}

	public void inputToList() {
		String[] tempData = inputData.split(",");
		int sum = 0;
		int avg = 0;
		 
		list.add(String.valueOf(count));
		if (tempData.length == 3) {
			for (int i = 0; i < tempData.length; i++) {
				list.add(tempData[i]+"   ");
			}
			count++;

			sum += Integer.parseInt(tempData[1].trim()) + Integer.parseInt(tempData[2].trim());
//			System.out.println(sum);
			avg = sum / 2;
//			System.out.println(avg);
			list.add(String.valueOf(sum+"   "));
			list.add(String.valueOf(avg+"   "));
			list.add("\n");
		}
	}

	public void showList() {
		StringTokenizer stk = new StringTokenizer(list.toString(),",.[.]");
		s= new StringBuffer();
		System.out.println(stk.countTokens());
		while(stk.hasMoreTokens()){
			s.append(stk.nextToken());
        }
//		System.out.println(s);
		jta.append(String.valueOf(s));
		jsp = new JScrollPane(jta);
		System.out.println(String.valueOf(jsp));
		JOptionPane.showMessageDialog(null,jsp);
	}
	
	public static void main(String[] args) {
		new Work1217();
	}// main
}
