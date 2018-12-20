package day1204;

import java.util.ArrayList;
//import java.util.*; //패키지 내의 모든 class(Interface)를 한번에 사용할 수 있다.
import java.util.Date;
//import java.awt.List; //패키지는 다르나 이름이 같은 클래스는 
//둘 중 하나마 import 받을 수 있다.
import java.util.List;
import java.util.Random;


/**
 *다른 클래스를 참조하여 사용할때 import를 사용한다.
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();
		Random r1 = new Random();
		Random r2 = new Random();
		
		Date d = new Date();
		
		//같은 이름의 클래스(interface)는 둘 중 많이 사용되는 것을 import로 처리하고
		//적게 사용되는 것을 full path로 처리한다.
		java.awt.List list = null; //awt.List
		List list1 = null; //util.List
		
	}

}
