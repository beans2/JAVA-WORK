package day1204Test;

/**
 * �������̽��� method�� �Ű������� �� �����ϰ� ����ϴ� ���.<br>
 * 
 * @author owner
 */
public class TestAnony {
	public void mixMsg(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}
	public static void main(String[] args) {
		//1.���� Ŭ������ ��üȭ
		AnonyImpl an= new AnonyImpl();
		//2. mixMsg�� ����ϱ� ���� ��üȭ
		TestAnony ta= new TestAnony();
		//3. �޼ҵ� ȣ��
		ta.mixMsg(an);
		
		/////////////////////////////////////anonymous ���////////////////////////////////////////////
		ta.mixMsg(new AnonyInter() {
			
			@Override
			public String getName() {
				return "��ȫ���Ӵ�";
			}
			
			@Override
			public String getMsg() {
				return "�ȳ��ϼ�"+test();
			}
			public String test() {
				return "�ڽĸżҵ��Դϴ�";
			}
		});

	
		
	}//main

}//class
