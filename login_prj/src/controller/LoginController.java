package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import login.dao.LoginDAO;
import login.view.LoginView;
import login.view.SignUpView;
import login.view.UserView;
import login.vo.LoginVO;

public class LoginController extends WindowAdapter implements ActionListener, MouseListener {
	private LoginView lv =null;
//	private String id;
//	private String pw;
	private UserView uv;
	private Thread tr;
	public LoginController(LoginView lv) {
		this.lv = lv;
	}
	private String login( LoginVO lvo) {
		String name = "";
		LoginDAO l_dao = LoginDAO.getInstance();
		
		try {
		name = l_dao.login(lvo);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(lv, "DB에서 문제가 발생했습니다.");
			e.printStackTrace();
		}
		return name;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		lv.dispose();
	}
	
	@Override
	public void windowClosed(WindowEvent we) {
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String id= lv.getJtfId().getText().trim();
		String pw= new String(lv.getJpfPw().getPassword());
		LoginVO alvo = new LoginVO(id, pw);
		String name =login(alvo);
		if(ae.getSource()==lv.getJbLogin()) {
			if(id==null||id.equals("")) {
				JOptionPane.showMessageDialog(lv, "아이디를 입력하세요.");
				lv.getJtfId().requestFocus();
				return;
			}
			if(pw==null||pw.equals("")) {
				JOptionPane.showMessageDialog(lv, "비밀번호를 입력하세요.");
				lv.getJpfPw().requestFocus();
				return;
			}
			if(name.equals("")) {
				JOptionPane.showMessageDialog(lv, "아이디나 비밀번호를 확인해주세요.");
				lv.getJtfId().setText("");
				lv.getJpfPw().setText("");
				lv.getJtfId().requestFocus();
			}else {
				if(id.equals("admin")) {
					uv =new UserView(lv);
					tr= new Thread(uv);
					tr.start();
				}
			}
			
		}

		if(ae.getSource()==lv.getJbSignUp()) {
			new SignUpView(lv);
		}
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		if(SwingUtilities.isLeftMouseButton(me)){
			JOptionPane.showMessageDialog(lv, "비번찾기");
		}
	}

	
	
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}


}
