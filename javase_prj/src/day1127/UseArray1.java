package day1127;

/**
 * 1차원배열: 행하나에 열로만 구성된 배열<br>
 * 배열 - 메모리에 동일데이터형으로 나열된 데이터형<br>
 * 참조형 데이터형, 고정길이 형<br>
 * 일괄처리시 사용.<br>
 * 방의 수를 얻기 (배열명.length)
 * 
 * @author owner
 */
public class UseArray1 {
	/**
	 * 1차원 배열을 참조형 형식으로 사용.
	 */
	public UseArray1(){
		//1. 배열선언) 데이터형[] 배열명=null;
		int[] arr=null;
		//2. 배열생성) 배열명=new 데이터형 [방의갯수];
		//배열을 생성하면 모든 방의 값이 초기화된다.
		arr=new int[6];
		//1+2선언과 생성) 데이터형[] 배열명=new 데이터형[방의 갯수];
		int[] arr1=new int[8];
		System.out.println(arr+"/"+arr1);
		System.out.println("arr배열 방의 갯수 "+arr.length+" arr1배열 방의 갯수 "+arr1.length);
		//3. 값할당) 배열명[방의 인덱스]=값;
		arr[0]=11;
		arr[1]=27;
		arr[2]=14;
		arr[3]=46;
		//4. 값 사용)
		System.out.printf("arr[0]=%d,arr[1]=%dmarr[2] =%d\n",arr[0],arr[1],arr[2]);
		//배열에 없는 인덱스를 사용한면 error.
//		arr[6]=10;
		System.out.println("arr[5]="+arr[5]);
		System.out.println("=============================");
		//일괄처리
		for(int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d] = %d\n",i,arr[i]);
		}//end for
	}//UseArray1
	
	/**
	 * 1차원 배열의 기본형 형식의 사용. new사용x
	 */
	public void arrayPrimitive() {
		System.out.println("=============기본형 형식의 사용===============");
		//1.선언: 데이터형[] 배열명 = {값,,,,,,};
		int[] arr= {2018,11,27,15,20};
		System.out.println("방의 수: "+arr.length);
		int[] arr1=new int[] {1,2,3,4,5,6,7}; //방의 갯수를 정의하면 error
		System.out.println("arr1의 방의수 : "+arr1.length);
		
		arr[0]=2019;
		System.out.println(arr[0]+"/"+arr[1]);
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"]="+arr[i]);
		}//end for
		
		//향상된 for: 배열이나 collection(list,set)의 처음 방부터 끝방까지 
		//모든 방의 값을 순차적으로 손쉽게 출력할 때
		//for(배열방의 값을 저장한 변수: 배열){
//					변수명
//		}
		for(int value:arr1) {
			System.out.println(value);
		}//end for
		//배열의 마지막방부터 처음방까지 출력
		System.out.println("-----------------");
		for(int i=arr1.length-1;i>=0;i--) {
			System.out.print(arr1[i]+"   ");
		}
	}//arrayPrimitive
		
	public static void main(String[] args) {
		new UseArray1().arrayPrimitive();
	}//main
}//class
