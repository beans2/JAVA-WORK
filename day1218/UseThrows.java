package day1218;

import java.util.Random;

/**
 *method ������ �߻��� ���ܸ� method�� ȣ���� ������ ó���ϴ� throws�� ���
 * @author owner
 */
public class UseThrows {
	public void test() throws ClassNotFoundException{
		//throws�� ���ܸ� ������ method�ȿ� try~catch�� �� �ʿ䰡 ����.\
		String className = "day1217.UseRuntimeException";
		Object obj =Class.forName(className);		
		if(new Random().nextBoolean()) {
			className = "java.long.Integer";
		}//end if
			

		System.out.println("Ŭ���� �ε�"+obj);
	}//test
	public static void main(String[] args) {
		UseThrows ut = new UseThrows();
		try {
			ut.test();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�˼��մϴ�");
			cnfe.printStackTrace();
			System.out.println("�������");
		}
	}

}
