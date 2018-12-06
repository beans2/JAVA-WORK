package day1205;

/**
 * Math: 객체를 생성하지 않고 사용하는 클래스.
 * @author owner
 */
public class UseMath {

	public UseMath() {
//		Math m= new Math();
		int i =-12;
		System.out.println(i+ " 의 절대값: "+Math.abs(i));
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.round(10.5));//소수점 이하 첫자리에서 올림
		System.out.println(Math.floor(10.9));//소수점 이하 첫자리에서

		double d=Math.random();
		System.out.println("범위를 설정한 난수: "+d*5);
		System.out.println("범위를 설정한 난수에서 정수: "+(int)(d*5));
		
		
		//A(65)-Z(90) 중 하나의 문자를 반환하는 일.
		System.out.println((char)((int)(d*26)+65));
		System.out.println("---------------------------------");
		
		
	}//UseMath
	public char[] createPassword() {
		char[] tempPass = new char[8];
		//영문자대문자(65~90), 소문자(97~122), 숫자(48~57)로 이루어진 임의의 비밀번호 8자리를 생성하여 //
		//반환하는 일
		
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
		
		///////////////////////////////////////////쌤이한거시작///////////////////////////////////////////////////////
//		String flag="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//		for(int i=0;i<tempPass.length;i++) {
//			tempPass[i]=flag.charAt((int)(Math.random()*flag.length()));
//			System.out.print(tempPass[i]);
//		}//end for
//		return tempPass;
		///////////////////////////////////////////쌤이한거끝///////////////////////////////////////////////////////
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
