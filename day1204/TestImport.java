package day1204;

import java.util.ArrayList;
//import java.util.*; //��Ű�� ���� ��� class(Interface)�� �ѹ��� ����� �� �ִ�.
import java.util.Date;
//import java.awt.List; //��Ű���� �ٸ��� �̸��� ���� Ŭ������ 
//�� �� �ϳ��� import ���� �� �ִ�.
import java.util.List;
import java.util.Random;


/**
 *�ٸ� Ŭ������ �����Ͽ� ����Ҷ� import�� ����Ѵ�.
 * @author owner
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();
		Random r1 = new Random();
		Random r2 = new Random();
		
		Date d = new Date();
		
		//���� �̸��� Ŭ����(interface)�� �� �� ���� ���Ǵ� ���� import�� ó���ϰ�
		//���� ���Ǵ� ���� full path�� ó���Ѵ�.
		java.awt.List list = null; //awt.List
		List list1 = null; //util.List
		
	}

}
