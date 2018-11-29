package day1115;
/*
1. 변수에 할당된 값이 양수일때만 2진수로 출력하고 음수라면 ~를 사용하여
    양수로 변경하고 입력된 그대로의 10진수로 출력.
    출력 예)  " 양수 인경우"  10은  1010
                 "음수 인경우"  -10 은 10
*/

/* 1번문제
class Work16 {
	public static void main(String[] args){
		int i=-10;
		System.out.print( i>=0 ? "\"양수 인경우\" " : " \"음수 인경우\" " );
		System.out.print( i+ "은 "+ (i>=0 ? Integer.toBinaryString(i): ~i+1));	
	}
}
*///1번 끝
/*
2. 2147483647의 값에서 상위 2byte와 하위 2byte 값을 분리하여 출력해보세요. 
    출력 예) 상위 2byte -> 32767
                하위 2byte - > 65535
*/
/*
class Work16 {
	public static void main(String[] args){
		int i=2147483647;
		int j =2147483647;
		System.out.println(Integer.toBinaryString(i));
		System.out.println("상위 2byte ->"+(i>>=16));
		//j<<=16;
		//System.out.println(Integer.toBinaryString(j<<=16));
		System.out.println("하위 2byte ->"+(-(j<<=16)));
	}
}
*/
/*
3. ||를 사용했을 때 전항이 true라면 후항을 연산하지 않는 것을 증명할 수 있는
     코드를 작성하세요.
*/
class Work16 {
	public static void main(String[] args){
		boolean flag1=true, i=(3<5);

		System.out.println(flag1+"와 " + (i=3>5)+"의 or :"+(flag1||i));

	}
}
