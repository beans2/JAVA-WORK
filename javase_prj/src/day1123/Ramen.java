package day1123;

/**
 * 라면을 객체화해서 만든 클래스<br>
 * 명사적특징: 면발굵기, 스프 갯수, 메이커<br>
 * 동사적특징: 끓여짐
 * @author owner
 *
 */
public class Ramen {
	private String name,thickness,maker;
	private int soupnum;
	
	public Ramen() {
		this("너구리","굵음","농심",3);
	}
	public Ramen(String name, String thickness, String maker, int soupnum) {
		this.name = name;
		this.thickness = thickness;
		this.maker = maker;
		this.soupnum = soupnum;
	}
	
	/**
	 * 생성된 라면객체에 이름을 설정하는 일 
	 * @param name 라면이름
	 */
	public void setName(String name) {
		this.name=name;
	}//setName
	
	/**
	 * 생성된 라면객체의 면발굵기를 설정하는 일<br>
	 * 만약 "얅음", "중간", "굵음"이 아닌 것이 입력된다면<br>
	 * "중간"으로 지정해줌
	 * @param thickness 면발굵기
	 */
	public void setThickness(String thickness) {
		if(!(thickness.equals("얇음")||thickness.equals("중간")
			||thickness.equals("굵음"))) {
			thickness = "중간";
		}
		this.thickness=thickness;
	
	}//setThickness
	
	/**
	 * 생성된 라면 객체에 메이커를 설정하는 일
	 * @param maker
	 */
	public void setMaker(String maker) {
		this.maker=maker;
	}//setMaker
	
	/**
	 * 생성된 라면 객체의 스프갯수를 설정하는 일
	 * @param soupnum
	 */
	public void setSoupnum(int soupnum) {
		this.soupnum=soupnum;
	}//setSoupnum
	
	/**
	 * 생성된 라면객체의 이름을 반환하는 일
	 * @return 라면이름
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * 생성된 라면객체의 면발굵기를 반환하는 일
	 * @return 면발굵기
	 */ 
	public String getThickness() {
		return thickness;
	}//getThickness
	
	/**
	 * 생성된 라면객체의 메이커를 반환하는 일
	 * @return 메이커
	 */
	public String getMaker() {
		return maker;
	}//getMaker
	
	/**
	 * 생성된 라면객체의 스프갯수를 반환하는 일
	 * @return 스프갯수
	 */
	public int getSoupnum() {
		return soupnum;
	}//getSoupnum
	
	/**
	 * 동사적특징<br>
	 * 생성된 라면객체가 끓는 것을 구현
	 * @return 결과
	 */
	public String boil() {
		return name+"라면이 끓는 중이다";
	}
	/**
	 * 생성된 라면객체의 끓어야하는 시간(분)을 알려주는 것을 구현
	 * @param time 끓는 시간
	 * @return 결과
	 */
	public String boil(String time) {
		return name+"라면은"+time+" 끓여야한다고 적혀있다";
	}
	
	
}
