package day1218;

import java.util.Stack;

public class DataClone extends Data {
	private Stack<Data> historyStack;

	public DataClone() {
		historyStack = new Stack<Data>();
	}// DataClone

	public void useData() throws CloneNotSupportedException {
		Data d = new Data("쌍용유치원");
		if (d instanceof Cloneable) {

			d.setSchool("쌍용 초등학교");
			Data d1 = d.getData();
			historyStack.push(d1);
			d.setSchool("쌍용중학교");
			Data d2 = d.getData();
			historyStack.push(d2);
			d.setSchool("쌍용고등학교");
			Data d3 = d.getData();
			historyStack.push(d3);
			d.setSchool("쌍용대학교");
			historyStack.push(d.getData());

			getHistoryData();
			
		} else {
			System.out.println("Cloneable만 처리합니다.");
		} // end else
	}// useData

	public void getHistoryData() {
		Data temp = null;
		while (!historyStack.empty()) {
			temp = historyStack.pop();
			System.out.println(temp);
			System.out.println(temp.getSchool());
		} // end while
	}// getHistoryData

	public static void main(String[] args) {
		try {
			new DataClone().useData();
		} catch (CloneNotSupportedException e) {
			System.err.println("복제되지 않습니다");
			e.printStackTrace();
		} // catch
	}// main

}// class
