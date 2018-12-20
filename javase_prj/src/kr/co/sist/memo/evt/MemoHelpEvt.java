package kr.co.sist.memo.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.memo.view.MemoHelp;

public class MemoHelpEvt extends WindowAdapter implements ActionListener {
	private MemoHelp mh;
	public MemoHelpEvt(MemoHelp mh) {
		this.mh = mh;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		mh.dispose();
	}

}
