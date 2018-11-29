package day1122;

/**
 *������: method Overload<br>
 * �ϳ��� Ŭ�������� ���� �̸��� method�� ������ �ۼ��ϴ� ��<br>
 * ��Ģ) ���������� ��ȯ�� method���� ���� �����,
 * 			�Ű������� �ٸ��� �ۼ�
 * @author owner
 */
public class TestOverload {
	
	/**
	 * ���� �ϳ� ����ϴ� ��
	 */
	public void printStar() {
		System.out.println("��");
	}//printStar
	/**
	 * �ԷµǴ� ���� ���� ���� ������ ����ϴ� ��
	 * @param count ����� ���� ����
	 */
	public void printStar(int count) {
		for(int i=0;i<count;i++) {
			System.out.println("��");			
		}
	}
	/**
	 * ������ 3���� ����ϴ� method
	 */
	public void printGugudan() {
		int i=3;
			System.out.println("������ 3�� ����Դϴ�");
			for(int j=2;j<10;j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
	}//printGugudan
	/**
	 * �Է��ϴ� ���� 2~9�� ������ �� �ش� �ܺ��� 9�ܱ����� ����ϴ� method
	 * @param dan �������� ������ �� �Ű�����
	 */
	public void printGugudan(int dan) {	
		System.out.println(dan+" �� ���� 9�ܱ����� ����Դϴ�.");
		System.out.println();
		for(int i=dan;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
		}//end for
	}
	
	public static void main(String[] args) {
		TestOverload to = new TestOverload();
		//�� 1�� ���
		to.printStar();
		//�� 5�� ���
		to.printStar(5);
		
		//������ 3���� ����ϴ� method
		
		//�Է��ϴ� ���� 2~9�� ������ �� �ش� �ܺ��� 9�ܱ����� ����ϴ� method
		to.printGugudan();
		System.out.println("--------------------------");
		int i= Integer.parseInt(args[0]);
		if(i>1&&i<10) {
			to.printGugudan(i);
		}
	}//main
}//class
