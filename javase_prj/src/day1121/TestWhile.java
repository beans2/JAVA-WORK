package day1121;

/**
 *while : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 *			�ּ� 0�� ���� �ִ� ���Ǳ��� ����<br>
 *	����) while(���ǽ�) {<br>
 *			�ݺ����๮��;<br>
 *			}
 *
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;//�ʱⰪ
		
		while(i<10) {//���ǽ�
			System.out.println("i = "+i);//�ݺ����๮��
			i++;
		}//end while
		
		System.out.println("=======================================");
		//���� �Է¹޾� 2~9�� ���̶�� �������� ���
		i= Integer.parseInt(args[0]);
//		if(i>1&&i<10) {
//			for(int k=2;k<i;k++) {
//				for(int j=1;j<10;j++) {
//					System.out.println(k+" * "+j+" = "+ k*j);
//				}//end for
//			}//end for
//		}else {
//			System.out.println("not print");
//		}
		//while��
		int k=2;
		int j=1;
		while(k<10) {
				
				while(j<10) {
					System.out.println(k+" * "+j+" = "+ k*j);
					j++;	
				}//end while
			j=1;	
			k++;
		}//end while
		
		//while 
//		i=0;
//		while(true) {
//				System.out.println("����loop");
//				if(i==5) {
//					break;
//				}//end if
//				i++;
//		}//end while
	}//main

}//class
