
/*2016�� 1�� 1���� �ݿ����Դϴ�. 
2016�� a�� b���� ���� �����ϱ��? 
�� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, 
solution�� �ϼ��ϼ���. ������ �̸��� 
�Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT�Դϴ�. 
���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� TUE�� ��ȯ�ϼ���.

���� ����
2016���� �����Դϴ�.
2016�� a�� b���� ������ �ִ� ���Դϴ�.
 (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)
*/

import java.awt.image.DataBufferUShort;
import java.util.Calendar;

/**
 * @author owner
 *
 */
class Test1 {

	public String solution(int a, int b) {
		int month = a;
		int dayOfMonth = b;
		String answer = "";
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.YEAR, 2016);
		cld.set(Calendar.MONTH,month+1);
		cld.set(Calendar.DAY_OF_MONTH,dayOfMonth);
		int c =0;
		if(cld.MONTH==2) {
			c = cld.getActualMaximum(Calendar.DAY_OF_MONTH)-2;								
		}else {
			c = cld.getActualMaximum(Calendar.DAY_OF_MONTH);					
		}
		if((month<13)&&(month>0)) {
//			System.out.println(month+"/"+dayOfMonth+"/"+c);
			if((dayOfMonth<=c)&&(dayOfMonth>0)){
				String[] dow = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
				System.out.println("����"+dow[cld.get(Calendar.DAY_OF_WEEK) -1]);
				answer = dow[cld.get(Calendar.DAY_OF_WEEK)-1];			
				System.out.println(answer);
			}else {
				System.out.println("�Է°��� ��¥�� �ƴմϴ�.");				
			}
			}else {
			System.out.println("�Է°��� ���� �ƴմϴ�.");
		}
		return answer;
	}
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.solution(5,24);
	}

}