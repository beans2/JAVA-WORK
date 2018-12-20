package day1121;

public class Work19 {
	int i=2;
	int j=0;
	int k=0;
	int m=0;
	public void instantGugudanMethod(){   //숙제1.instance method로 작성한 구구단 전체단 출력
		Work19 w1= new Work19();
		while(w1.i<10) {
			w1.j=1;
			while(w1.j<10) {
				System.out.println(w1.i+" + "+w1.j+" = "+w1.i*w1.j);
				w1.j++;
			}//end while
			w1.i++;
		}//end while
	}//end method
//	public static void staticStar() { //숙제2.스태틱 변수를 선언한 *모양 출력
//		Work19 w2=new Work19();
//		do {
//			for(w2.m=0; w2.m<w2.k ;w2.m++) {
//				System.out.print("*");
//			}//end for	
//			System.out.println();
//			w2.k++;
//		}while(w2.k<5); //end do~while
//	}
	public static void staticStar() { //숙제2. 스태틱 변수를 사용하지 않는 for를 이용한 *모양 출력
		int k=0;
		do {
			for(int m=0; m<k ;m++) {
				System.out.print("*");
			}//end for	
			System.out.println();
			k++;
		}while(k<5); //end do~while
	}
	public static void main(String[] args) {
		Work19 work1 = new Work19();
		work1.instantGugudanMethod();
		staticStar();
	}//main
}//class
