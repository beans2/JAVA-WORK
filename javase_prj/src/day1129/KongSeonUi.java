package day1129;

public class KongSeonUi extends Person {
	public String ability;
	public KongSeonUi() {
		ability = "swim";
	}
	public String abilityKong(String ability) {
		String result ="";
		if(ability.equals("swim")) {
			result = "Ư���̴�";
		}else {
			result= "Ư�Ⱑ �ƴϴ�";
		}
		return result;
	}
}//class
