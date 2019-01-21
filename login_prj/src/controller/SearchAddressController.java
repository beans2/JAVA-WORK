package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import login.dao.LoginDAO;
import login.view.LoginView;
import login.view.SearchAddressView;
import login.view.SignUpView;
import login.vo.AddressVO;

public class SearchAddressController extends WindowAdapter implements ActionListener {
	private SearchAddressView sav;
	private SignUpView suv;
	private LoginDAO l_dao;
	public SearchAddressController(LoginView lv, SignUpView suv,SearchAddressView sav) {
		l_dao = LoginDAO.getInstance();
		this.sav = sav;
		this.suv = suv;
	}
	
	public boolean searchAddr(String dong){
		boolean flag =false;
		try {
		
			List<AddressVO> list = l_dao.selectAddress(dong);
			DefaultTableModel dtm = sav.getDtmZip();
			dtm.setRowCount(0);
			if(list.isEmpty()) {
				flag = true;
			}
			
			Object[] rowData = null;
			AddressVO av = null;
			
			for(int i=0;i<list.size();i++) {
				av = list.get(i);
				rowData = new Object[5];
				rowData[0] = av.getZipcode();
				rowData[1] = av.getSido();
				rowData[2] = av.getGugun();
				rowData[3] = av.getDong();
				rowData[4] = av.getBunji();

				dtm.addRow(rowData);
			}
//			
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(suv, "DB 문제발생....");
			se.printStackTrace();
		}//end catch
		return flag;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		sav.dispose();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==sav.getJbSearch()) {
			if(sav.getJtfDong().getText().trim().equals("")||sav.getJtfDong().getText().trim()==null) {
				JOptionPane.showMessageDialog(sav, "동을 입력하세요.");
				return;
			}
			String addr = sav.getJtfDong().getText().trim();
			if(searchAddr(addr)){
				JOptionPane.showMessageDialog(sav, "조회된 결과가 없습니다.");
			}
		}
		if(ae.getSource()==sav.getJbOk()) {
			int row = sav.getJtZip().getSelectedRow();
			suv.getJtfAddrBunji().setText(sav.getJtZip().getValueAt(row, 0).toString());
			StringBuilder addr = new StringBuilder();
			addr
			.append(sav.getJtZip().getValueAt(row,1))
			.append(sav.getJtZip().getValueAt(row,2))
			.append(sav.getJtZip().getValueAt(row,3))
			.append(sav.getJtZip().getValueAt(row,4));
			
			suv.getJtfAddress().setText(addr.toString());
			suv.getJtfAddMore().requestFocus();
			sav.dispose();
		}
		if(ae.getSource()==sav.getJbCancel()) {
			sav.dispose();
		}
	}

}
