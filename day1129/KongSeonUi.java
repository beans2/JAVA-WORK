package day1129;

public class KongSeonUi extends Person {
	public String ability;
	public KongSeonUi() {
		ability = "swim";
	}
	public String abilityKong(String ability) {
		String result ="";
		if(ability.equals("swim")) {
			result = "특기이다";
		}else {
			result= "특기가 아니다";
		}
		return result;
	}
}//class
