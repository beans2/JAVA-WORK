package day1123;

/**
 *라면을 객체화한 Ramen 클래스를 사용하는 클래스
 * @author owner
 */
public class UseRamen {

	public static void main(String[] args) {
		//너구리 라면 객체생성
		Ramen neoguri = new Ramen();
//		neoguri.setName("너구리");
//		neoguri.setThickness("굵음");
//		neoguri.setMaker("농심");
//		neoguri.setSoupnum(3);
		
		System.out.printf("[%s] 라면의 면발굵기는 [%s] 이고 [%s] 사 제품이다. 스프의 개수는 [%d] 개이다.\n ", neoguri.getName(),
				neoguri.getThickness(),neoguri.getMaker(),neoguri.getSoupnum());
		System.out.println(neoguri.boil());
		System.out.println(neoguri.boil("5분"));
		System.out.println("----------------------------------------------------------------------------------");
		//오징어짬뽕 라면 객체생성
		Ramen ozzam = new Ramen("오징어짬뽕","중간","농심",2);
//		ozzam.setName("오징어짬뽕");
//		ozzam.setThickness("중간");
//		ozzam.setMaker("농심");
//		ozzam.setSoupnum(2);
		
		System.out.printf("[%s] 라면의 면발굵기는 [%s] 이고 [%s] 사 제품이다. 스프의 개수는 [%d] 개이다.\n ", ozzam.getName(),
				ozzam.getThickness(),ozzam.getMaker(),ozzam.getSoupnum());
		System.out.println(ozzam.boil());
		System.out.println(ozzam.boil("4분30초"));
		System.out.println("----------------------------------------------------------------------------------");
		//신라면 라면 객체생성
		Ramen sin = new Ramen("신라면","중간","농심",2);
//		sin.setName("신라면");
//		sin.setThickness("중간");
//		sin.setMaker("농심");
//		sin.setSoupnum(2);
		
		System.out.printf("[%s] 라면의 면발굵기는 [%s] 이고 [%s] 사 제품이다. 스프의 개수는 [%d] 개이다.\n ", sin.getName(),
				sin.getThickness(),sin.getMaker(),sin.getSoupnum());
		System.out.println(sin.boil());
		System.out.println(sin.boil("4분30초"));
	
	}//main

}//class
