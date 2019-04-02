package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {

	/**
	 * ��� ���迡�� Is A �� ��� �ϴ� �޼���
	 */
	public void useIsA() {
		Map<String, Person> map = new HashMap<String,Person>();
		// �� �Ҵ�.
		map.put("Gong", new SeonUi());
		map.put("Lee", new JaeHyun());
		map.put("Jung", new TeackSung());

		// Ű
		String key = "Gong";

		if (map.containsKey(key)) {
			// ��ü�������� ����Ͽ� �����ϴ� Ŭ������ ����Ѵ�.
			Person person = map.get(key);
			System.out.println(person.execute());
		} // end if

	}// useIsA

	/**
	 * Is A �� ��� ���� �ʴ� �޼���
	 */
	public void notUseIsA() {
		Map<String, Object> map = new HashMap<>();

		// �� �Ҵ�.
		map.put("Gong", new SeonUi());
		map.put("Lee", new JaeHyun());
		map.put("Jung", new TeackSung());

		// �� ���.
		String key = "Gong";
		if ("Gong".equals(key)) {
			SeonUi su = (SeonUi) map.get(key);
			System.out.println(su.execute());
		} // end if
		if ("Jung".equals(key)) {
			TeackSung ts = (TeackSung) map.get(key);
			System.out.println(ts.execute());
		} // end if
		if ("Lee".equals(key)) {
			JaeHyun jh = (JaeHyun) map.get(key);
			System.out.println(jh.execute());
		} // end if

	}// useIsA

	public static void main(String[] args) {
		Run run = new Run();
		run.useIsA();
		System.out.println("���м� : --------------------------");
		run.notUseIsA();
	}// main

}// class
