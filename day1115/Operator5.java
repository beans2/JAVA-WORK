package day1115;
/*
	논리연산자: 
	일반논리
		&& :전항과 후항이 모두 true일때만 true반환
		|| :전항과 후항이 모두 false 일때만 false반환
	비트논리
		& (AND): 상위비트와 하위비트 모두 1인경우 1내림
		| (OR): 상위비티와 하위비트 모두 0인경우 0내림
		^ (XOR)-exclusive OR: 상위비트와 하위비트 둘 중 하나만 1인경우 1내림.
*/
class Operator5 {
	public static void main(String[] args) {
		boolean flag1=true, flag2=false,flag3=true,flag4=false;
		int i=0,j=0;
		
		System.out.println("-----------------&&-----------------");
		System.out.println(flag1+"&&"+flag3+" = "+(flag1&&flag3));//true
		System.out.println(flag1+"&&"+flag2+" = "+(flag1&&flag2));//false
		//전항이 false이면 후항을 계산하지 않고 false인 결과를 만든다.
		System.out.println(flag2+"&&"+flag1+" = "+(flag2&&flag1));//false
		System.out.println(flag2+"&&"+flag4+" = "+(flag2&&flag4));//false

		System.out.println("-----------------||-----------------");
		System.out.println(flag1+"||"+flag3+" = "+(flag1||flag3));//true
		System.out.println(flag1+"||"+flag2+" = "+(flag1||flag2));//true
		//전항이 false이면 후항을 계산하지 않고 false인 결과를 만든다.
		System.out.println(flag2+"||"+flag1+" = "+(flag2||flag1));//true
		System.out.println(flag2+"||"+flag4+" = "+(flag2||flag4));//false

		System.out.println("-----------------||-----------------");
		flag1 = false;
		flag2 = false;
		flag3 = false;

		flag3=(flag1=(3>4))&&(flag2=5>4); //&&은 전항이 false 면 후항을 계산하지 않는다.
		System.out.println("전항: "+flag1+", 후항: "+flag2+ ",판정 : "+flag3);


		System.out.println("-----------------&-----------------");
		
		i=28;
		j=48;
		System.out.println(i+"&"+j+"="+(i&j));
		i=16;
		j=3;
		System.out.println(i+"&"+j+"="+(i|j));
		i=5;
		j=12;
		System.out.println(i+"&"+j+"="+(i^j));



	}//main
}//class

