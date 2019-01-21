package vo;

public class UserInfoVO {
	private String id, name, password,tel,email, address, ssn, question, answer;

	public UserInfoVO(String id, String name, String password, String tel, String email, String address, String ssn,
			String question, String answer) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.ssn = ssn;
		this.question = question;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getSsn() {
		return ssn;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "UserInfoVO [id=" + id + ", name=" + name + ", password=" + password + ", tel=" + tel + ", email="
				+ email + ", address=" + address + ", ssn=" + ssn + ", question=" + question + ", answer=" + answer
				+ "]";
	}
	
	
}
