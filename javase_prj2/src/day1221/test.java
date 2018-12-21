package day1221;

public class test {
	public test() {
		String s ="C:/dev/temp/java_read.txt";
		System.out.println(s);
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb.insert(s.lastIndexOf("."),"_bak"));
	}
	public static void main(String[] args) {
		new test();
	}
}
