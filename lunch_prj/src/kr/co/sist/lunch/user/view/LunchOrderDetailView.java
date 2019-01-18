package kr.co.sist.lunch.user.view;

import javax.swing.JDialog;
import javax.swing.JFrame;

import kr.co.sist.lunch.user.vo.LunchDetailVO;

@SuppressWarnings("serial")
public class LunchOrderDetailView extends JDialog{
	
	public LunchOrderDetailView(LunchClientView lcv,LunchDetailVO ldvo) {
		super(lcv,ldvo.getLunchName()+" 도시락 상세정보",true);
		
		setBounds(lcv.getX()+100,lcv.getY()+50,400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}//LunchOrderDetailView
}//class
