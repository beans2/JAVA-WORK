package day1119;

/**
 * else ~if : ������ ���� ������ ���� ��.<br>
 * ����)if(���ǽ�){<br>
 * ���ǿ� ���� �� ������ ����<br>
 * }else if(���ǽ�){<br>
 * ���ǿ� ���� �� ���� ����;<br>
 * }else if(���ǽ�){<br>
 * ���ǿ� ���� �� ���� ����;<br>
 * }else if(���ǽ�){<br>
 * ���ǿ� ���� �� ���� ����;<br>
 * .<br>
 * .<br>
 * .<br>
 * <br>
 * }else{<br>
 * ��� ���ǿ� ���� ���� �� ���๮��;<br>
 * }
 * 
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {
		/*
		 * int i=Integer.parseInt(args[0]);
		 * 
		 * System.out.println(i+"��(��)"); if(i < 0) { System.out.println("0���� �۾Ƽ� ����");
		 * }else if(i>100) { System.out.println("100���� Ŀ�� ����"); }else {
		 * System.out.println("�Է¼���"); }//end else
		 */
		// �̸��� �Է¹޾� "������"�̸� ������
		// "�̺���, �ڿ���, ������, ������:�̸� ������
		// �׷��� ������ "���"�� �̸��տ� ����ϼ���. "��å �̸�"

		/*
		 * String i = args[0];
		 * 
		 * if (i.equals("������")) { System.out.println("���� " + i); } else if
		 * (i.equals("�̺���") || i.equals("�ڿ���") || i.equals("������") || i.equals("������")) {
		 * System.out.println("���� " + i); } else { System.out.println("��� " + i); }
		 */

		// �¾ �ظ� �Է¹޾� �� ���ϱ�
		// 11- ��, 10-��, 9-��, 8-��, 7-�䳢,6-ȣ����,5-��, 4-��, 3-����,
		// 2-��, 1-��, 0-������
		int i = Integer.parseInt(args[0]);
		if (i % 12 == 11) {
			System.out.println("��");
		} else if (i % 12 == 10) {
			System.out.println("��");
		} else if (i % 12 == 9) {
			System.out.println("��");
		} else if (i % 12 == 8) {
			System.out.println("��");
		} else if (i % 12 == 7) {
			System.out.println("�䳢");
		} else if (i % 12 == 6) {
			System.out.println("ȣ����");
		} else if (i % 12 == 5) {
			System.out.println("��");
		} else if (i % 12 == 4) {
			System.out.println("��");
		} else if (i % 12 == 3) {
			System.out.println("����");
		} else if (i % 12 == 2) {
			System.out.println("��");
		} else if (i % 12 == 1) {
			System.out.println("��");
		} else {
			System.out.println("������");
		}

	}// main

}// class
