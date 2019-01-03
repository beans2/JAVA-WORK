package kr.co.sist.multichat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import kr.co.sist.multichat.client.view.ClientChatView;
import kr.co.sist.multichat.client.view.ClientSelectTeamView;

public class ClientSelectTeamEvt implements ActionListener, ItemListener {
	private int selectTeam;
	private ClientSelectTeamView cstv;
	

	public ClientSelectTeamEvt(ClientSelectTeamView cstv) {
		this.cstv = cstv;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			System.out.println(selectTeam);	
			new ClientChatView(selectTeam);
			cstv.dispose();
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(cstv, "조를 선택해주세요.");			
			npe.getMessage();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		selectTeam=0;
		if (ie.getSource() == cstv.getJrTeam1()) {
			selectTeam = 11000;
		} else if (ie.getSource() == cstv.getJrTeam2()) {
			selectTeam = 12000;
		} else if (ie.getSource() == cstv.getJrTeam3()) {
			selectTeam = 13000;
		} else if (ie.getSource() == cstv.getJrTeam4()) {
			selectTeam = 14000;
		}
	}

}
