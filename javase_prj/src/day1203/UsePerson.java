package day1203;

import java.util.Arrays;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd=new HongGilDong();
		gd.setName("홍길동");//부모의 method 사용
		System.out.println("눈"+ gd.getEye()+",코 :"+gd.getNose()+",입: "+gd.getMouse());
		System.out.println(gd.eat());
		System.out.println(gd.eat("국밥",1));
		//자신만의 특징
		System.out.println(gd.fight(6));//7>8
		System.out.println(gd.fight(7));//8>9
		System.out.println(gd.fight(9));//비김
		System.out.println(gd.fight(10));//진다. 9>8
		System.out.println(gd.fight(9));//진다. 8>7
		System.out.println("---------------------------------");
		Clark superman = new Clark(); //자식이 생성되면 부모클래스가 먼저 생성된 후 자식이 생성된다.
		//자식의 객체로 부모클래스의 자원(변수, method)를 자식의 것처럼 
		//사용할 수 있다. - 코드의 재 사용성
		superman.setName("클락");
		
		System.out.println(superman.getEye()+"/"+superman.getNose()
			+"/"+superman.getMouse()+"/"+superman.getName());
		
		System.out.println(superman.eat());
		System.out.println(superman.eat("스테이크",10));
		
		//자신(자식)의 자원(변수,method)
		String stone="짱돌";
		stone="클립토나이트";
		System.out.println(stone+"을 맞은 결과 "+superman.power(stone)+", 힘의변화: "+
									superman.power );
		stone="다이아몬드";
		System.out.println(stone+"을 맞은 결과 "+superman.power(stone)+", 힘의변화: "+
				superman.power );
		
		System.out.println("----------------------------------------");
		String[] clarkLang=superman.language("외계어");
		clarkLang=superman.language("영어");

		System.out.println(Arrays.toString(clarkLang));
		
		String[] hongLang=gd.language("한국어");
		hongLang=gd.language("중국어");
		hongLang=gd.language("수화");
		
		System.out.println(Arrays.toString(hongLang));
		System.out.println("----------------------------------------");
		//Clark은 interface를 구현하였으므로 비행가능
		System.out.println(superman.speed("빠르"));
		System.out.println(superman.height("높게"));
		
//		KongSeonUi kse= new KongSeonUi();
////		kse.setName("공선의");
//		String ability="swim";
//		System.out.println(kse.getName()+"의 눈의 갯수: "+kse.getEye()+", 코의 갯수 "+kse.getNose()+", 입의 갯수 "
//				+kse.getMouse()+" 이다");
//		System.out.println(kse.eat());
//		System.out.println(kse.eat("자장면", 1000));
//		System.out.println(ability+"은(는) "+kse.getName()+"의 "+kse.abilityKong(ability));
//		ability="running";
//		System.out.println(ability+"은(는) "+kse.getName()+"의 "+kse.abilityKong(ability));
//		String s= new String("오늘은 금욜");
//		System.out.println(s);
//		Date d= new Date();
//		System.out.println(d.getYear());
	
	}
}
