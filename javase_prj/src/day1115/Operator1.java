package day1115;
/*
	���׿�����(Unary)
	~,!,+,-,++,--
*/

class  Operator1{
	public static void main(String[] args) {
		int i=11;
		int j=-11;
		//1�Ǻ��� ������ ~
		//~���: ��ȣ����1����
		System.out.println("~"+i+"="+ ~i); //-12
		System.out.println("~"+i+"="+ ~j);//10

		//!(NOT): ture -> false, false -> true
		boolean b=true;
		boolean c=false;
		System.out.println("!"+b+"="+ !b); //false
		System.out.println("!"+c+"="+ !c); //true
		System.out.println(!(11>15)); //!�� boolean���� ��밡��

		//+����������
		System.out.println("+"+i+"="+  +i); //11
		System.out.println("+"+j+"="+  +j); //-11

		//- ��ȣ�ٲ� : 2�Ǻ���
		System.out.println("-"+i+"="+  -i); //-11
		System.out.println("-"+j+"="+  -j); //11

		//++:��������(���ü�� ���� 1�� ����)
		i=0;
		j=10;
		
		//��������: ������ ���ü;
		++i; // 0->1
		--j; //10 ->9
		System.out.println("�������� �� : i ="+i+",j =" +j);
		//��������: ���ü ������;
		i++;// 1->2
		j--; // 9->8
		System.out.println("�������� �� : i ="+i+",j =" +j);
		
		//���������ڿ� ���ҿ����ڴ� ���Կ����ڿ� �Բ� ���Ǹ�
		//������ ������ �ٸ� ���� �����Ѵ�.
		j=0;
		//����: ���� ����
		j=++i;
		System.out.println("���������� i:" +i+",���� j: " +j);
		//����: ���� �� ����
		j=0;
		j=i++;
		System.out.println("�������� �� i: "+i+ ",���� j: " +j);

		
	}//main
}//class
