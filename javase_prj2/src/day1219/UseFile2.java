package day1219;

import java.io.File;

/**
 * 폴더생성, 파일삭제
 * @author owner
 */
public class UseFile2 {
	public void cerateDirectory() {
		File file = new File("c:/seonui/kong");
		if(file.mkdirs()) {
			System.out.println("폴더생성성공");
		}else {
			System.out.println("같은 이름의 폴더 존재");
		}
	}//cerateDirectory
	public void removeFile() {
		File file = new File("c:/dev/temp/a.txt");
		boolean flag = file.delete();
		if(flag) {
			System.out.println("파일 삭제 성공");
		}else {
			System.out.println("파일 삭제 실패");
		}
	}
	public static void main(String[] args) {
		UseFile2 uf2 = new UseFile2();
		uf2.cerateDirectory();
		System.out.println("-----------------------------");
		uf2.removeFile();
	}//main

}//class
