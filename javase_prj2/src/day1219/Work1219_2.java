package day1219;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Work1219_2 {
	private File[] fileList;
	private List<Integer> listIdx;
	private File file;
	
	//경로를 입력받고 조건에 따라 구현한 메소드를 수행하는 메소드
	public void progress() {
		String str;
		str = JOptionPane.showInputDialog("디렉토리 경로를 입력하세요 예)c:/dev/temp");
		if ((str != null) && (!str.isEmpty())) {
			file = new File(str);
			if (file.exists()) {
				deleteFile();
			} else {
				System.out.println("지정된 경로를 찾을 수 없습니다.");
			} // end if
		} else {
			JOptionPane.showMessageDialog(null, "경로를 입력하세요");
		} // end if
	}//deleteDirectory
	
	
	//리스트에 java를 확장자로 가지는 파일의 인덱스들만 걸러서 리스트저장
	public void javaFileIndex() { 
		listIdx = new ArrayList<Integer>();
		for (int i = 0; i < fileList.length; i++) { //count;
			if (fileList[i].getName().contains(".java")) {
				listIdx.add(i);
			} // end if
		} // end for
//		return count;
	}//countFile
	
	//java 확장자를 포함하는 파일을 삭제하는 메소드
	public void deleteFile() {
		fileList = file.listFiles();
		javaFileIndex();
		int confirm = JOptionPane.showConfirmDialog(null, "java파일이" + listIdx.size() + "개 존재합니다." + "삭제하시겠습니까?");
		if (confirm == JOptionPane.OK_OPTION) {
			for (int i = 0; i < listIdx.size(); i++) {
				fileList[listIdx.get(i)].delete();

			} // end for
		} // end if
	}
	
	public static void main(String[] args) {
		Work1219_2 wk2 = new Work1219_2();
		wk2.progress();
	}
}
