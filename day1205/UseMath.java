package day1205;

/**
 * Math: ��ü�� �������� �ʰ� ����ϴ� Ŭ����.
 * @author owner
 */
public class UseMath {

	public UseMath() {
//		Math m= new Math();
		int i =-12;
		System.out.println(i+ " �� ���밪: "+Math.abs(i));
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.round(10.5));//�Ҽ��� ���� ù�ڸ����� �ø�
		System.out.println(Math.floor(10.9));//�Ҽ��� ���� ù�ڸ�����

		double d=Math.random();
		System.out.println("������ ������ ����: "+d*5);
		System.out.println("������ ������ �������� ����: "+(int)(d*5));
		
		
		//A(65)-Z(90) �� �ϳ��� ���ڸ� ��ȯ�ϴ� ��.
		System.out.println((char)((int)(d*26)+65));
		System.out.println("---------------------------------");
		
		
	}//UseMath
	public char[] createPassword() {
		char[] tempPass = new char[8];
		//�����ڴ빮��(65~90), �ҹ���(97~122), ����(48~57)�� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� //
		//��ȯ�ϴ� ��
		
//		char bigeng =' '; // (char)((int)(Math.random()*26)+65);
//		char smalleng = ' ';// (char)((int)(Math.random()*26)+97);
//		char number = ' ';//(char)((int)(Math.random()*10)+48);
		char[] coun = new char[3];
		int flag = 0;
		for(int i=0; i<8;i++) {
			coun[0] = (char)((int)(Math.random()*26)+65);
			coun[1] = (char)((int)(Math.random()*26)+97);
			coun[2] = (char)((int)(Math.random()*10)+48);
			flag= (int)(Math.random()*3);
			tempPass[i] = coun[flag];
			System.out.print(tempPass[i]);
		}
		System.out.println("\n-------------------------------------");
		return tempPass;
		
		///////////////////////////////////////////�����ѰŽ���///////////////////////////////////////////////////////
//		String flag="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//		for(int i=0;i<tempPass.length;i++) {
//			tempPass[i]=flag.charAt((int)(Math.random()*flag.length()));
//			System.out.print(tempPass[i]);
//		}//end for
//		return tempPass;
		///////////////////////////////////////////�����Ѱų�///////////////////////////////////////////////////////
	}//createPassword
//	public void lotto() {
//		int[] rottonum = new int[6];
//		for(int i=0;i<6;i++) {
//			rottonum[i]= (int)(Math.random()*44+1);
//			for(int j=i;j<6;j++) {
//				
//			}
//			System.out.print(rottonum[i]+" ");
//		}
//		
//	}
	public static void main(String[] args) {
		new UseMath();
		UseMath um = new UseMath();
		um.createPassword();
//		um.lotto();
	}//main

}//class
