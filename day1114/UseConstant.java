package day1114;
/*
	�ٸ� Ŭ������ ����� ����غ��� ���� Ŭ���� 
*/

class UseConstant {
	public static void main(String[] args){
		//�ٸ�Ŭ������ �����ϴ� ����� �ݵ�� "Ŭ������.�����"�� ������ ������.
		//System.out.println(MAX_SCORE);
		System.out.println(Constant.MAX_SCORE+ "/"+ 
			Constant.MIN_SCORE);
		int deci=15;
		int octal=017;
		int hexa=0xf;
		int tel=0101234;
		System.out.println(deci+octal+hexa);
		System.out.println(tel);
	}//main
}//class
