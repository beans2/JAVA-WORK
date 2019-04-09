package kr.co.sist.exam.vo;

public class homeworkVO {
	private String country, maker, model;

	public homeworkVO(String country, String maker, String model) {
		super();
		this.country = country;
		this.maker = maker;
		this.model = model;
	}

	public String getCountry() {
		return country;
	}

	public String getMaker() {
		return maker;
	}

	public String getModel() {
		return model;
	}
	
}
