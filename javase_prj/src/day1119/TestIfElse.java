package day1119;

/**
 *if~else: �� �� �ϳ��� �ڵ带 �����ؾ��� �� ���<br>
 *����) if (���ǽ�){<br>
 *			���ǿ� ���� �� ������ �����<br>
 *		}else{<br>
 *			���ǿ� ���� ���� �� ������ �����;<br>
 *		}
 *
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {
			int i=-20;
/*			//������ �����ϴ� ���� �������� ��������� �Ǵ�
			System.out.println(i+"��(��)");
			if(i<0) {
				System.out.println("����");
			}else {
				System.out.println("���");
			}//end if
			//������ �����ϴ� ���� Ȧ������ ¦�������� �Ǵ�
			//�����ϴ� ����� �����̶�� {�� ������ �� �ִ�.
		
			if(i%2==0) {
				System.out.println("¦��");
			}else {
				System.out.println("Ȧ��");			
			}//end if
			
			//�Է��ϴ� ���� 3�� ������ "¦"�� ����ϰ� �׷��� �ʴٸ� 
			//�Է��� ���� ����ϼ���.
*/			
			int j=Integer.parseInt(args[0]);
			if(j%3==0) {
				System.out.println("¦ ");
			}else {
				System.out.println(j);
			}
			
		}//main
}//class