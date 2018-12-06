package day1205;

import java.util.StringTokenizer;

/**
 *���ڿ��� ª�� ����� �����ϴ� StringTokenizer���
 * @author owner
 */
public class UseStringTokenizer {
	public UseStringTokenizer() {
		String msg = "������ ������ �Դϴ�. ������ -5�Դϴ�.";
		
		//�������� ���� : �Ű����� �ϳ��� �����ڸ� ���
		StringTokenizer stk = new StringTokenizer(msg);
		System.out.println(stk.countTokens()+" ��");
		while(stk.hasMoreTokens()) { //��ū�� �����ϴ���?
			System.out.println(stk.nextToken()); //��ū�� ��� �����͸� �������� �̵�					
		}//end while
		
		String names="������,������~���ü�,����ö.������~������,������";
		
		//Ư�� ���ڷ� ��ū ���� : �Ű����� �ΰ��λ�����
		StringTokenizer stk1 = new StringTokenizer(names, ",~ ");
		System.out.println("--------------------------------------");
		System.out.println("��ū�� ��: " +stk1.countTokens());
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}//end while
		
		//Ư�����ڷ� ��ū ����, ���е� ���ڿ��� ��ū���� ó�� :
		//�Ű����� ������ ������
		
		StringTokenizer stk2 = new StringTokenizer(names, ",.~",true);
		System.out.println(" ------------------------------------");
		System.out.println("��ū�� ��: " +stk2.countTokens());

		while(stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}//end while
		
		
	}//UseStringTokenizer
	public static void main(String[] args) {
		new UseStringTokenizer();
	}

}
