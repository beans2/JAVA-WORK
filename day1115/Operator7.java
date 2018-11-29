package day1115;
/*
	댜입연산자
	=,
	+=,-=,*=,/=,%=
	<<=,>>=,>>>=
	&=,|=,^=
*/



class Operator7{
	public static void main(String[] args) {
		int i=3;// 대입
		//산술대입
		i+=2;//5
		i-=1; // 4
		i*=2; //8
		i/=3;//
		i%=3;

		//쉬프트 대입
		i<<=4; // i=i<<4;
		i>>=1; // i=i>>1;
//		System.out.println(i);//debug목적 method 개발시 값 확인용
		//실행중인 코드에 출력코드가 존재하면 속도가 느려진다.
		i>>>=2; 
		//비트논리대입
		i&=12;// i=i&12;//0100  & 1100 = 0100
		i|= 11; //i=i|11=1111;
		i^=5; // i=i^5// 1111^010= 1010
		System.out.println(i);

	}
}
