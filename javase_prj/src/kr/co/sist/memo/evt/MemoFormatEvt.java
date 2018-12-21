package kr.co.sist.memo.evt;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kr.co.sist.memo.view.MemoFormat;

public class MemoFormatEvt extends WindowAdapter implements ActionListener, ItemListener {

	private MemoFormat mf;

	public MemoFormatEvt(MemoFormat mf) {
		this.mf = mf;
	}// MemoFormatEvt

	@Override
	public void windowClosing(WindowEvent we) {
		mf.dispose();
	}// windowClosing

	@Override
	public void itemStateChanged(ItemEvent ie) {
		String selectedValue = ((List) ie.getSource()).getSelectedItem(); // ie란 이벤트의 주소(getSource)를 List로 캐스팅하여
																			// 해당 리스트의 값을 String형으로 반환
		Font temp = mf.getLblPreview().getFont();
		String font = temp.getFamily();
		int style = temp.getStyle();
		int size = temp.getSize();

		// 선택한 아이템을 T.F에 값으로 설정한다.
		// 미리보기 라벨을 변경
		if (ie.getSource() == mf.getListFont()) {
			mf.getTfFontText().setText(selectedValue);
			font = selectedValue; // String형 선택된 글꼴을 font에 저장
		} // end if
		if (ie.getSource() == mf.getListStyle()) {
			mf.getTfStyleText().setText(selectedValue);
			style = ((List) ie.getSource()).getSelectedIndex(); // getSelectedIndex로 선택된 글꼴스타일을 index번호로 반환.
		} // end if
		if (ie.getSource() == mf.getListSize()) {
			mf.getTfSizeText().setText(selectedValue);
			size = Integer.parseInt(selectedValue); // String형의 선택된 글자크기를 정수형으로 변경해서 저장
		} // end if
			// 설정된 정보 중 변경된 정보만 가지고 preview의 글꼴정보를 변경한다.
		mf.getLblPreview().setFont(new Font(font, style, size));
	}// itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mf.getBtnYes()) { // 설정한 글꼴 정보를 적용
			setTaNoteFont();
			mf.dispose();
		} // end if
		if (ae.getSource() == mf.getBtnNo()) {// 닫힘
			mf.dispose();
		} // end if
	}// actionPerformed

	/**
	 * MemoFormat 클래스의 미리보기 Label에 Font정보를 JavaMemo클래스의 TextArea에 설정
	 */
	public void setTaNoteFont() {
		mf.getJm().getTaNote().setFont(mf.getLblPreview().getFont());
		try {
			fontStatusSave(); // 설정한 글꼴 상태정보를 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
		mf.dispose();
	}// setTaNoteFont

	/**
	 * 설정한 폰트 상태를 파일로 저장 -다음번에 프로그램이 실행되면 
	 * 현재 저장된 폰트 값을 적용하여 TA를 설정하면 변경상태가 유지된다.
	 */
	private void fontStatusSave() throws IOException{
//		BufferedWriter bw = null;
		ObjectOutputStream oos = null;
		
		try {
			//미리보기에 라벨의 설정된 폰트정보를 얻는다.
			Font fontTemp = mf.getLblPreview().getFont();
			oos= new ObjectOutputStream(new FileOutputStream("c:/dev/temp/memo.dat"));
			oos.writeObject(fontTemp);
			oos.flush();
//			StringBuilder fontData = new StringBuilder();
//			fontData.append(fontTemp.getFamily()).append(",").append(fontTemp.getStyle()).append(",")
//			.append(fontTemp.getSize());
			
//			bw= new BufferedWriter(new FileWriter("c:/dev/temp/memo.dat"));
//			bw.write(fontData.toString());
//			bw.flush();
			
			
		}finally {
			if(oos!=null) {oos.close();}//end if
		}
	}//fontStatusSave
}// class
