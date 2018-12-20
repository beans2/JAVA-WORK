package day1121;

/**
 *while : 시작과 끝을 모를 때 사용하는 반복문<br>
 *			최소 0번 수행 최대 조건까지 수행<br>
 *	문법) while(조건식) {<br>
 *			반복수행문장;<br>
 *			}
 *
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;//초기값
		
		while(i<10) {//조건식
			System.out.println("i = "+i);//반복수행문장
			i++;
		}//end while
		
		System.out.println("=======================================");
		//단을 입력받아 2~9단 사이라면 구구단을 출력
		i= Integer.parseInt(args[0]);
//		if(i>1&&i<10) {
//			for(int k=2;k<i;k++) {
//				for(int j=1;j<10;j++) {
//					System.out.println(k+" * "+j+" = "+ k*j);
//				}//end for
//			}//end for
//		}else {
//			System.out.println("not print");
//		}
		//while로
		int k=2;
		int j=1;
		while(k<10) {
				
				while(j<10) {
					System.out.println(k+" * "+j+" = "+ k*j);
					j++;	
				}//end while
			j=1;	
			k++;
		}//end while
		
		//while 
//		i=0;
//		while(true) {
//				System.out.println("무한loop");
//				if(i==5) {
//					break;
//				}//end if
//				i++;
//		}//end while
	}//main

}//class
