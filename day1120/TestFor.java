package day1120;

/**
 * for: ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * ����: for(���۰� ; ����; ����,���ҽ�){<br>
 * �ݺ����๮��;<br>
 * }
 * 
 * @author owner
 */
public class TestFor {

	public static void main(String[] args) {
		// 0�������� 10���� ���� ������ �ݺ������ϴ� for

//		for (int i = 0; i < 10; i++) {
//			System.out.println(i + " �� �ȳ�");
//		} // end for
//
//		
//		// 1�������� 100���� ¦���� ������ ����ϴ� for
//		for (int i = 1; i < 101; i++) {
//			if (i % 2 == 0) {
//				System.out.print(i + " ");
//			}
//		} // end for
//		System.out.println();// �ٺ���
//		
//		
//		// 1�������� 100���� Ȧ���� ������ ���
//		// �����ҽ��� ������ ���� ��ȭ��Ű�� ���� ��ų�� �ִ� ��� �����ڸ� ����� �� �ִ�.
//		int cnt = 0;
//		for (int i = 1; i < 101; i += 2) {
//			cnt++;
////			if(i%2==1) {
//			System.out.print(i + " ");
////			}
//		} // end for
//		System.out.println("\n" + cnt + "��");
		//1~100���� ����ϱ� 3�� ������� ���ڴ�� "¦"�� ���
		for(int i=1; i<101;i++) {
			if(i%3==0) {
				System.out.println("¦ ");
			}else {
				System.out.print(i+" ");
			}
		}//end for
		//1~100������ �� ���: 5050
		int sum=0;
		for(int i=1;i<101;i++) {
			sum+=i;	
		}
		System.out.println("\n"+"1~100������ �� ���: "+sum);
		
		char alp=' ';
		//A~Z���� ���
		for(int i=65;i<91;i++) {
			alp = (char)i;
			System.out.print(alp+" ");
		}
		System.out.println();
		for(char c='A';c<='Z';c++) {
			System.out.print(c+" ");
		}
		System.out.println();
		
		//������ 2��
		for(int i=1; i<10; i++) {
			System.out.println("2* "+i+"= "+(2*i));
		}
	}// main
}// class
