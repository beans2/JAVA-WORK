package day1203;

/**
 * interface�� �����ϴ� class (�ڽ�Ŭ�����̰� interface�� ��� 
 * �߻�method�� Override�ϴ� Ŭ����)
 * ���� interface�� �θ� interface�� �����ٸ� �������� �ڽ�Ŭ���������� 
 * ��� �߻�method�� �����ؾ��Ѵ�. 
 * 
 * @author owner
 */
public class InterfaceImpl implements SuperInterface{
	
	public String msg() { //InterA
		return "������ ȭ����";
	}
	public String msgB() {//InterB
		return "������ ������";
	}//msgB
	
	@Override
	public void methodA() {//SuperInterface
		System.out.println("methodA");
	}//methodA

	@Override
	public void methodB(int i) { //SuperInterface
		System.out.println("methodB");		
	}//methodB
	public static void main(String[] args) {
		//�ڽ� Ŭ������ ��üȭ : ��� method�� ȣ���� �� �ִ�.
		//ii.msg(), ii.msgB(), ii.methodA(), ii.methodB(), ii.test
		InterfaceImpl ii= new InterfaceImpl();
		ii.methodB(12);
		
		//is a ������ ��üȭ
		//SuperInterface�� ��üȭ�� �ϸ� Override�� method �� ȣ��
		//�θ��� method�� ��� ȣ�� ����
		//si.msg(), si.msgB(), si.methodA(), si.methodB()
		SuperInterface si=new InterfaceImpl();
		System.out.println(si.msg());
		
		//InterA�� ��üȭ�ϸ� : ia.msg�� ȣ�Ⱑ��.
		InterA ia=new InterfaceImpl();
		System.out.println(ia.msg());
		
		InterB ib= new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//Object o=new InterfaceImpl
		//interface�� ��üȭ���� �ʴ´�.
//		InterA ia1=new InterA();
//		SuperInterface si1 = new SuperInterface(); //������ ��üȭ �ȵǰ� �ڽ��� ���ؼ��� ��ü�� ���������.
			
		
		
	}//main

}//class
