package day1203;

public class TestSub2 extends TestSuper{
	int i;
	public TestSub2() {
		super();
		System.out.println("�ڽ��� ������22222222");
	}//TestSub
	
	public void subMEthod() {
		System.out.println("�ڽ��� subMethod222222222");
	}//subMethod
	
	@Override
	public void printI() {
		System.out.println("�ڽ�2222222 �� Override�� method"+this.i+
				", �θ��� i = "+super.i);
	}//prientI
	


}//class
