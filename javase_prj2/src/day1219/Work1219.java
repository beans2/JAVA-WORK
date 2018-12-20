package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Work1219 {
	public void progress() {
		System.out.println("디렉토리를 입력하세요. 예)c:/dev");
		String str = " ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			str =br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(str); //디렉토리 경로
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		if(file.exists()) {
			File[] fileList=file.listFiles();
			for(int i=0;i<fileList.length;i++) {
//				System.out.println(fileList[i]);
				sb.append("출력\n이름\t\t유형\t\t크기\t\t마지막으로수정한날짜\n").append(fileList[i].getName()+"\t\t")
				.append((fileList[i].isFile()?"파일":"폴더")+"\t\t").append(fileList[i].length()+"kb\t\t").append(sdf.format(fileList[i].lastModified())+"\n");
			}
			JTextArea jta = new JTextArea(50,100);
			jta.append(sb.toString()); //화면을 구성한 데이터를 JTA에 붙여준다.
			JScrollPane jsp = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null, jsp);
		}else {
			System.out.println("파일은 취급하지 않습니다");
		}
	}
	
	public static void main(String[] args) {
	Work1219 tf = new Work1219();
	tf.progress();
	}//main
}
