package day1115;
/*
1. ������ �Ҵ�� ���� ����϶��� 2������ ����ϰ� ������� ~�� ����Ͽ�
    ����� �����ϰ� �Էµ� �״���� 10������ ���.
    ��� ��)  " ��� �ΰ��"  10��  1010
                 "���� �ΰ��"  -10 �� 10
*/

/* 1������
class Work16 {
	public static void main(String[] args){
		int i=-10;
		System.out.print( i>=0 ? "\"��� �ΰ��\" " : " \"���� �ΰ��\" " );
		System.out.print( i+ "�� "+ (i>=0 ? Integer.toBinaryString(i): ~i+1));	
	}
}
*///1�� ��
/*
2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
    ��� ��) ���� 2byte -> 32767
                ���� 2byte - > 65535
*/
/*
class Work16 {
	public static void main(String[] args){
		int i=2147483647;
		int j =2147483647;
		System.out.println(Integer.toBinaryString(i));
		System.out.println("���� 2byte ->"+(i>>=16));
		//j<<=16;
		//System.out.println(Integer.toBinaryString(j<<=16));
		System.out.println("���� 2byte ->"+(-(j<<=16)));
	}
}
*/
/*
3. ||�� ������� �� ������ true��� ������ �������� �ʴ� ���� ������ �� �ִ�
     �ڵ带 �ۼ��ϼ���.
*/
class Work16 {
	public static void main(String[] args){
		boolean flag1=true, i=(3<5);

		System.out.println(flag1+"�� " + (i=3>5)+"�� or :"+(flag1||i));

	}
}
