package day1123;

/**
 * ����� �߻�ȭ �Ͽ� ���� Person Ŭ������ ����ϴ� Ŭ����
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		//��ü���� : heap�� �����ǰ� instance������ �ڵ� �ʱ�ȭ
		Person teacksung=new Person();
		//������ ���������� Person�� heap�� �ּҸ� ������ �ִ�.
		System.out.println("��ü�� ����ϸ� �ּҰ� ��� "+teacksung);
		teacksung.setName("���ü�");
//		teacksung.setEye(2);
//		teacksung.setMouse(1);
//		teacksung.setNose(1);
		System.out.format("������ ��� ��ü ���� ��[%d],��[%d],��[%d],�̸�[%s]\n",
				teacksung.getEye(),teacksung.getNose(),teacksung.getMouse(),teacksung.getName());
		//������ ��ü���� ���ǵ� ���� ��Ŵ
		System.out.println(teacksung.eat());
		System.out.println(teacksung.eat("��ȸ�����",8000));

		
		Person jinban=new Person(3,1,1);
		jinban.setName("õ����");
//		jinban.setEye(3);
//		jinban.setNose(1);
//		jinban.setMouse(1);
		
		System.out.println("---------------------------------------------------------");
		System.out.format("������ ��� ��ü ���� ��[%d],��[%d],��[%d],�̸�[%s]\n",
				jinban.getEye(),jinban.getNose(),jinban.getMouse(),jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("����",1));
		
	}//main

}//class
