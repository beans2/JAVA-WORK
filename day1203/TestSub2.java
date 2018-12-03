package day1203;

public class TestSub2 extends TestSuper{
	int i;
	public TestSub2() {
		super();
		System.out.println("자식의 생성자22222222");
	}//TestSub
	
	public void subMEthod() {
		System.out.println("자식의 subMethod222222222");
	}//subMethod
	
	@Override
	public void printI() {
		System.out.println("자식2222222 이 Override한 method"+this.i+
				", 부모의 i = "+super.i);
	}//prientI
	


}//class
