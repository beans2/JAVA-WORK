package day1114;
/*
1. �Ʒ��� ���� ������ ������ ����� ����� ������.

   �̴ϼ� : 'K', ���� : �ڽ��ǳ���, �޴��÷� : 1.5, ������ �÷� : 0.8

   ��� : ���� �̴ϼ��� 'K'�̰�, xx���Դϴ�. �÷��� �޴� xx, ������ xx�Դϴ�.

*/
/*
class Work15 {
	public static void main(String[] args) {
		char initial = 'K';
		int age = 27;
		float left_eye = 1.5f;
		float right_eye = 0.8f;

		System.out.println("���� �̴ϼ��� "+initial+"�̰�, "+age+
			"���Դϴ�. �÷��� �޴� "+left_eye+", ������ "+right_eye+"�Դϴ�.");		
	}
}
*///1��������
/*
2. �⺻�� ���������� �����Ǵ� Ŭ������ Wrapper Class��� �Ѵ�. 
   Java Document���� WrapperŬ������ ����� �����ϴ��� ã�ƺ��� 
   �׿� ���� �ּҰ��� �ִ밪�� ��� �Ѵ�. 
 
   ��� :  byte�� �ּҰ� :  -128  �ִ밪 : 127 
*/
class Work15 {
	public static void main(String[] args) {
		System.out.println("byte�� �ּҰ�: "+Byte.MIN_VALUE+" �ִ밪 :"+Byte.MAX_VALUE);
	}
}
