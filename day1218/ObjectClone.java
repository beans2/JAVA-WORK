package day1218;


/**
 * 객체 복제 : 복제되는 객체는 Cloneable Interface를 구현해야만 한다.
 * @author owner
 */
public class ObjectClone implements Cloneable {
	private int i	;

//	private Stack<ObjectClone> stack;
	public static void main(String[] args) {
	ObjectClone oc = new ObjectClone();
	oc.i =100;
	
	try {
		ObjectClone oc1 = (ObjectClone)oc.clone();
		System.out.println("복제성공\n"+oc1);
		oc.i =200; //현재객체의 상태가 변경
		System.out.println("원본: "+oc.i+" / 복제본"+ oc1.i);
	} catch (CloneNotSupportedException e) {
		e.printStackTrace();
	}
	
	}//main

}//class
