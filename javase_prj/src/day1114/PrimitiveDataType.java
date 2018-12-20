package day1114;
/*
기본형 데이터형
정수형: byte, short,int, long
문자형: char
실수형: float, double
불린형: boolean
*/

class PrimitiveDataType {  
	public static void main(String[] args) {
		//정수형
		byte a=10;
		short b=20;
		int c=30;
		long d=40; //할당되는 값이 4byte 내이므로 literal을 변환할 필요가 없음.
		long e=9200000000000000000L;
		//literal 에 저장이 되지 않으름로 literal의 크기를 변경 -형명시
		System.out.println("Byte:"+a+",Short"+b+",int:"+c+",long"+d+","+e);
		//문자형 : unicode 값: \u0000
		char f=66;//unicode값을 10진수로 할당가능
		//char f= 'A'; //할당: unicode
		char g='0';
		char h='가';
		//출력: unicode에 대한 문자 출력
		System.out.println("Char: "+f+","+g+","+h);

		//실수 
		float i=3.14f;//형명시 - 실수 literal 은 8byte 이고
						//float 데이터형은 4byte이므로 값할당이 되징 않는다.
		double j=3.14; //리터럴과 데이터형이 같으므로 형명시 생략할 수 있다.
		double k=3.14D;
		System.out.println("float: "+ i +",double:"+j+","+k);

		//불린형
		boolean l=true;
		boolean m= false;
		System.out.println("boolean: "+l+ "," +m);
		//byte b1=10, b2=20,result=0;
		//result = b1 + b2;
		//=> byte 와 byte로 더했지만 자동형변환으로 인해 int로 바꼈는데 이 값을 byte형식의 변수에 저장할 수 없어서 에러가 난다.
		byte b1=10, b2=20;
		int result=0;
		result = b1 + b2;
		System.out.println(result);
	}//main
}//class
