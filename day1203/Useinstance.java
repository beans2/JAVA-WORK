package day1203;

public class Useinstance {
	public TestSuper test1() {
		//is a������ ��üȭ : �θ��� �ڿ���, �ڽ��� Override�� method
		//�θ�Ŭ������ ��ü�� = new �ڽ�Ŭ����������();
		TestSuper ts= new TestSub();
		return ts;
	}
	public TestSuper test2() {
		//is a������ ��üȭ : �θ��� �ڿ���, �ڽ��� Override�� method
		//�θ�Ŭ������ ��ü�� = new �ڽ�Ŭ����������();
		TestSuper ts= new TestSub2();
		return ts;
	}
	public static void main(String[] args) {

		//�ڽ�Ŭ������ ��ü�� �����Ͽ� ���.
		//�ڽ�Ŭ������ ��ü�� = new �ڽ��ǻ�����();
		//��ü�� ��� : �θ�Ŭ������ ����, method, �ڽ�Ŭ������ ����, method
		TestSub ts= new TestSub();
		ts.i=100; //�θ�� ���� �̸��� ������ �ڽ��� ���� ���.
		ts.pMethod();// �θ��� method ���
		ts.subMEthod();//�ڽ��� method
		ts.printI();//�ڽ��� Override�� method�� ��� �ڽ��� methodȣ��
		
		System.out.println("--------�θ��� �̸����� ��üȭ : ��ü������ ---");
		//��ü������: ���� �̸��� Ŭ������ �پ��ϰ� ����ϴ� ��
		//�θ� ����� �� ������ �ȴ�.
		Useinstance ui= new Useinstance();
		
		TestSuper ts1= ui.test1();
		TestSuper ts2= ui.test2();
		
		//Override�� method ȣ��
		ts1.printI();
		ts2.printI();
	}//main

}//class
