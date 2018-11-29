package day1120;

/**
 *
 * @author owner
 */
public class TestFor2 {

	public static void main(String[] args) {
			//무한 loop
/*			for( ; ; ) {
				System.out.print("무한루프");
			}//end for
			System.out.println("무한루프");
*/	
	//증가하는 수를 세는 무한loop;
//		for(int i=2147000000; ;i++) {
//			System.out.println("무한loop"+i);
//			if(i==2147483647)
//			break; //break는 가장 인근에 존재하는 반복문을 빠져나간다.
//		}//end for
		
		//여러개의 초기값을 사용하는 for
		
/*		for(int i=0,j=10,k=30;i<10;i++,j++,k--) {
			System.out.println(i+" "+j+" "+k);
		}//end for
*/		
		//조건식을 잘못 설정하면 무한 loop
	/*	for(int i=0;i<10;i--) {
			System.out.println(i);
		}//end for
*/		
		int i=0;
		for(i=0;i<10;i++);{
			System.out.println("반복문"+i);
		}
	
	}//main

}//class
