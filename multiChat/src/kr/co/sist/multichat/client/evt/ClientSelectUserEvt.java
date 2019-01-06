package kr.co.sist.multichat.client.evt;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.multichat.client.view.ClientSelectUserView;

public class ClientSelectUserEvt extends WindowAdapter implements ItemListener {
	private ClientSelectUserView csuv;
	public ClientSelectUserEvt(ClientSelectUserView csuv) {
		this.csuv = csuv;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
	
}
