package day1203;

import java.util.Arrays;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd=new HongGilDong();
		gd.setName("ȫ�浿");//�θ��� method ���
		System.out.println("��"+ gd.getEye()+",�� :"+gd.getNose()+",��: "+gd.getMouse());
		System.out.println(gd.eat());
		System.out.println(gd.eat("����",1));
		//�ڽŸ��� Ư¡
		System.out.println(gd.fight(6));//7>8
		System.out.println(gd.fight(7));//8>9
		System.out.println(gd.fight(9));//���
		System.out.println(gd.fight(10));//����. 9>8
		System.out.println(gd.fight(9));//����. 8>7
		System.out.println("---------------------------------");
		Clark superman = new Clark(); //�ڽ��� �����Ǹ� �θ�Ŭ������ ���� ������ �� �ڽ��� �����ȴ�.
		//�ڽ��� ��ü�� �θ�Ŭ������ �ڿ�(����, method)�� �ڽ��� ��ó�� 
		//����� �� �ִ�. - �ڵ��� �� ��뼺
		superman.setName("Ŭ��");
		
		System.out.println(superman.getEye()+"/"+superman.getNose()
			+"/"+superman.getMouse()+"/"+superman.getName());
		
		System.out.println(superman.eat());
		System.out.println(superman.eat("������ũ",10));
		
		//�ڽ�(�ڽ�)�� �ڿ�(����,method)
		String stone="¯��";
		stone="Ŭ���䳪��Ʈ";
		System.out.println(stone+"�� ���� ��� "+superman.power(stone)+", ���Ǻ�ȭ: "+
									superman.power );
		stone="���̾Ƹ��";
		System.out.println(stone+"�� ���� ��� "+superman.power(stone)+", ���Ǻ�ȭ: "+
				superman.power );
		
		System.out.println("----------------------------------------");
		String[] clarkLang=superman.language("�ܰ��");
		clarkLang=superman.language("����");

		System.out.println(Arrays.toString(clarkLang));
		
		String[] hongLang=gd.language("�ѱ���");
		hongLang=gd.language("�߱���");
		hongLang=gd.language("��ȭ");
		
		System.out.println(Arrays.toString(hongLang));
		System.out.println("----------------------------------------");
		//Clark�� interface�� �����Ͽ����Ƿ� ���డ��
		System.out.println(superman.speed("����"));
		System.out.println(superman.height("����"));
		
//		KongSeonUi kse= new KongSeonUi();
////		kse.setName("������");
//		String ability="swim";
//		System.out.println(kse.getName()+"�� ���� ����: "+kse.getEye()+", ���� ���� "+kse.getNose()+", ���� ���� "
//				+kse.getMouse()+" �̴�");
//		System.out.println(kse.eat());
//		System.out.println(kse.eat("�����", 1000));
//		System.out.println(ability+"��(��) "+kse.getName()+"�� "+kse.abilityKong(ability));
//		ability="running";
//		System.out.println(ability+"��(��) "+kse.getName()+"�� "+kse.abilityKong(ability));
//		String s= new String("������ �ݿ�");
//		System.out.println(s);
//		Date d= new Date();
//		System.out.println(d.getYear());
	
	}
}
