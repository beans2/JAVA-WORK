package day1122;

/**
 *���� 
�Ʒ��� ������ ó���ϴ� method�� type�� �˸°� �ۼ��ϰ� API�ּ���
 ������ �� ȣ���Ͽ� ����� �� �� Java Doc�� �����غ�����.
- API�ּ��� � ������ method������ �ּ����� ����Ұ�.

1. �ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�.
2. ���̸� �Է¹޾� �¾ �ظ� ��ȯ�ϴ�  method �ۼ�.
3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�.
4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������
    ���ڸ�  ����ϴ� ���� �ϴ� method  �ۼ�
5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�.
6. ģ���� �̸��� �Է¹޾� ����ϴ�  method �ۼ�(ģ���� n�� �Դϴ�.) 
 * @author owner
 */
	
public class Work20 {
	
	/**
	 * 1. �ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�.
	 * @return �ڽ��� �̸� "������"�� ��ȯ��
	 */
	public String returnName(){
		return "������"; 
	}//end method1


	/**
	 * 2. ���̸� �Է¹޾� �¾ �ظ� ��ȯ�ϴ�  method �ۼ�.
	 * @param age �ڽ��� ���̸� �Է¹޴� �Ű�����
	 * @return ��ȯ�� �¾���� ��ȯ��
	 */
	public int returnYear(int age) {
		int year= 2018-age+1;
		return year;
	}//end method2

	/**
	 * 3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�.
	 * @param thing  �Է¹��� ������ �Ű�����
	 * @return ��ȯ�� �����ڵ尪
	 */
	public int returnUnicode(char thing) {
		int unicode = (int)thing;
		return unicode;
	}//end method3
	
	/**
	 * 4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������<br>
     *���ڸ�  ����ϴ� ���� �ϴ� method  �ۼ�
	 * @param num �Է¹��� ������ �Ű�����
	 * @return ��ȯ�� ������ �Ű�����
	 */
	public char returnCharac(int num){
		char charac = ' ';
		if(num>=65&&num<=90) {
			charac= (char)num;
		}else {
			System.out.println("���ڰ� �������� ���� �ʽ��ϴ�.");
		}//end if
		return charac;
	}//end method4
	
	/**
	 * 5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�.
	 */
	public void returnAddr(Work20 wk) {
		System.out.println(wk);
	}//end method5
	
	/**
	 * 6. ģ���� �̸��� �Է¹޾� ����ϴ�  method �ۼ�(ģ���� n�� �Դϴ�.) 
	 * @param name �������� ģ������ �̸��� �Է¹޴� �Ű����� 
	 */
	public  void returnFrendsName(String ... name) {
		for(int i=0;i<name.length;i++) {
			System.out.println(name[i]);
		}
	}//end method5
	public static void main(String[] args) {
		Work20 wk= new Work20();	
		System.out.println("----------------------1��--------------------------");
		System.out.println(wk.returnName()); 
		System.out.println("----------------------2��--------------------------");
		System.out.println(wk.returnYear(27));
		System.out.println("----------------------3��--------------------------");
		System.out.println(wk.returnUnicode('A'));
		System.out.println("----------------------4��--------------------------");
		System.out.println(wk.returnCharac(68));
		System.out.println("----------------------5��--------------------------");
		wk.returnAddr(wk);
		System.out.println("----------------------6��--------------------------");
		wk.returnFrendsName("��ö��","������","��â��");
	}//main

}//class
