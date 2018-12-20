package day1130;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK 1.5�������� �߰��� annotation�� ��� Deprecated ,Override, SupperessWarnings
 * 
 * @author owner
 */
public class UseAnnotation {
	/**
	 * �ڶ� ������ �߻���ų �� �ֽ��ϴ�.
	 */
	@Deprecated
	public void test() {
		System.out.println("���Ŀ� ������ �߻��� method");
	}// test

	public String toString() {
		return "�´����ʸ�";
	}// toString
	//method ���� �����ϸ� method ���� ��� ��� ��Ȳ�� �����Ѵ�.
	@SuppressWarnings({"rawtypes","unused"})
	public void temp() {
		//unused ������ ������� ���� �� ��� ����
//		@SuppressWarnings("unused")
		int i = 0;
		//rawtypes: Generic�� ������� ���� �� �����
		//�������� �����ϸ� �ٷ� �Ʒ� �ִ� ������ ��� �����ϰ� 
		List l=new ArrayList();
				
		
		int j = 0;
		System.out.println("temp j= " + j);
	}

	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		ua.test();
		System.out.println(ua);
	}// main

}// class
