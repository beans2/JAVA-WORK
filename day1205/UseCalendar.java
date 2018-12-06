package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar : 단일 날짜 정보를 얻을 때.
 * @author owner
 */
public class UseCalendar {
	public UseCalendar() {
		//Calendar 클래스의 인스턴스 얻기
		//1.getInstance 사용
//		Calendar cal=new Calendar();
		Calendar cal=Calendar.getInstance();
		//2. is a 관계
		Calendar cal1= new GregorianCalendar();
		//3. 자식으로만 객체 생성
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);
		
		int year= cal.get(Calendar.YEAR);//Constant를 사용하면 가독성 향상\
		
		System.out.println(year);
	}//UseCalendar
	public static void main(String[] args) {
		new UseCalendar();
	}//main

}//class
