package day1120;
//å 230~ 260
public class Work18 {

	public static void main(String[] args) {
//	//����1	
//		for(int i=1;i<10;i++) {
//			for(int j=2;j<10;j++) {
//				System.out.print(j+" * "+i+" = "+i*j+"    ");
//			}
//			System.out.println();
//		}
		
	//����2
//		for(int i=0;i<4;i++) {
//			for(int k=1;k<i;k++) {
//				if(i==0) {
//					continue;
//				}
//				System.out.print(" ");
//			}
//			for(int j=0;j<=i;j++) {
//				System.out.print(i+"  "+j+"  ");
//					
//			}//end for
//			
//			System.out.println();
	//end for
	//����2 �ٸ����	
		for(int i=0;i<4;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++) {
				System.out.print(i+ " "+ k+"  ");
			}
			System.out.println();
		}		
	}//main
}//class
