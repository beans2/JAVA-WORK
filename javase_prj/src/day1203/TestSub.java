package day1203;

public class TestSub extends TestSuper{
	int i;
	public TestSub() {
		super();
		System.out.println("�ڽ��� ������");
	}//TestSub
	
	public void subMEthod() {
		System.out.println("�ڽ��� subMethod");
	}//subMethod
	
	@Override
	public void printI() {
		System.out.println("�ڽ��� Override�� method ="+this.i+
				", �θ��� i = "+super.i);
	}//prientI
	


}//class
