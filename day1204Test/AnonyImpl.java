package day1204Test;
//2. 인터페이스를 객체화하기 위해 클래스 생성
public class AnonyImpl implements AnonyInter{

	@Override
	public String getName() {
		return "최홍만임다";
	}
	
	@Override
	public String getMsg() {
		return "안녕하쇼";
	}

}
