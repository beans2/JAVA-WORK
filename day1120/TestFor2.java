package day1120;

/**
 *
 * @author owner
 */
public class TestFor2 {

	public static void main(String[] args) {
			//���� loop
/*			for( ; ; ) {
				System.out.print("���ѷ���");
			}//end for
			System.out.println("���ѷ���");
*/	
	//�����ϴ� ���� ���� ����loop;
//		for(int i=2147000000; ;i++) {
//			System.out.println("����loop"+i);
//			if(i==2147483647)
//			break; //break�� ���� �αٿ� �����ϴ� �ݺ����� ����������.
//		}//end for
		
		//�������� �ʱⰪ�� ����ϴ� for
		
/*		for(int i=0,j=10,k=30;i<10;i++,j++,k--) {
			System.out.println(i+" "+j+" "+k);
		}//end for
*/		
		//���ǽ��� �߸� �����ϸ� ���� loop
	/*	for(int i=0;i<10;i--) {
			System.out.println(i);
		}//end for
*/		
		int i=0;
		for(i=0;i<10;i++);{
			System.out.println("�ݺ���"+i);
		}
	
	}//main

}//class
