package day1123;

/**
 *����� ��üȭ�� Ramen Ŭ������ ����ϴ� Ŭ����
 * @author owner
 */
public class UseRamen {

	public static void main(String[] args) {
		//�ʱ��� ��� ��ü����
		Ramen neoguri = new Ramen();
//		neoguri.setName("�ʱ���");
//		neoguri.setThickness("����");
//		neoguri.setMaker("���");
//		neoguri.setSoupnum(3);
		
		System.out.printf("[%s] ����� ��߱���� [%s] �̰� [%s] �� ��ǰ�̴�. ������ ������ [%d] ���̴�.\n ", neoguri.getName(),
				neoguri.getThickness(),neoguri.getMaker(),neoguri.getSoupnum());
		System.out.println(neoguri.boil());
		System.out.println(neoguri.boil("5��"));
		System.out.println("----------------------------------------------------------------------------------");
		//��¡��«�� ��� ��ü����
		Ramen ozzam = new Ramen("��¡��«��","�߰�","���",2);
//		ozzam.setName("��¡��«��");
//		ozzam.setThickness("�߰�");
//		ozzam.setMaker("���");
//		ozzam.setSoupnum(2);
		
		System.out.printf("[%s] ����� ��߱���� [%s] �̰� [%s] �� ��ǰ�̴�. ������ ������ [%d] ���̴�.\n ", ozzam.getName(),
				ozzam.getThickness(),ozzam.getMaker(),ozzam.getSoupnum());
		System.out.println(ozzam.boil());
		System.out.println(ozzam.boil("4��30��"));
		System.out.println("----------------------------------------------------------------------------------");
		//�Ŷ�� ��� ��ü����
		Ramen sin = new Ramen("�Ŷ��","�߰�","���",2);
//		sin.setName("�Ŷ��");
//		sin.setThickness("�߰�");
//		sin.setMaker("���");
//		sin.setSoupnum(2);
		
		System.out.printf("[%s] ����� ��߱���� [%s] �̰� [%s] �� ��ǰ�̴�. ������ ������ [%d] ���̴�.\n ", sin.getName(),
				sin.getThickness(),sin.getMaker(),sin.getSoupnum());
		System.out.println(sin.boil());
		System.out.println(sin.boil("4��30��"));
	
	}//main

}//class
