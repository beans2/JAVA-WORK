package day1114;
/*
�⺻�� ��������
������: byte, short,int, long
������: char
�Ǽ���: float, double
�Ҹ���: boolean
*/

class PrimitiveDataType {  
	public static void main(String[] args) {
		//������
		byte a=10;
		short b=20;
		int c=30;
		long d=40; //�Ҵ�Ǵ� ���� 4byte ���̹Ƿ� literal�� ��ȯ�� �ʿ䰡 ����.
		long e=9200000000000000000L;
		//literal �� ������ ���� �������� literal�� ũ�⸦ ���� -�����
		System.out.println("Byte:"+a+",Short"+b+",int:"+c+",long"+d+","+e);
		//������ : unicode ��: \u0000
		char f=66;//unicode���� 10������ �Ҵ簡��
		//char f= 'A'; //�Ҵ�: unicode
		char g='0';
		char h='��';
		//���: unicode�� ���� ���� ���
		System.out.println("Char: "+f+","+g+","+h);

		//�Ǽ� 
		float i=3.14f;//����� - �Ǽ� literal �� 8byte �̰�
						//float ���������� 4byte�̹Ƿ� ���Ҵ��� ��¡ �ʴ´�.
		double j=3.14; //���ͷ��� ���������� �����Ƿ� ����� ������ �� �ִ�.
		double k=3.14D;
		System.out.println("float: "+ i +",double:"+j+","+k);

		//�Ҹ���
		boolean l=true;
		boolean m= false;
		System.out.println("boolean: "+l+ "," +m);
		//byte b1=10, b2=20,result=0;
		//result = b1 + b2;
		//=> byte �� byte�� �������� �ڵ�����ȯ���� ���� int�� �ٲ��µ� �� ���� byte������ ������ ������ �� ��� ������ ����.
		byte b1=10, b2=20;
		int result=0;
		result = b1 + b2;
		System.out.println(result);
	}//main
}//class
