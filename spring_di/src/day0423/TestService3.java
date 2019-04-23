package day0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TestService3 {
	
	@Autowired
	private TestDAO3 td;
	
	
	public TestDAO3 getTestDao3() {
		return td;
	}//getTestDao3
}//class
