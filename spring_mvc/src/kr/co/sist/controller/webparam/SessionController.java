package kr.co.sist.controller.webparam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.vo.SessionVO;;
@SessionAttributes({"an_name","an_addr","an_flag"})
@Controller
public class SessionController {
	
	//��û�� Ư���̸����� ��� ó���ҷ��� values="/�����̸�/��û.do"�� ��������
	//����Ѵ�.
	@RequestMapping(value="/session/use_session.do", method=GET)
	public String sessionForm(HttpSession session) {
		//���� ���� Controller���� �ޱ�, HttpSession,�� �Ű������� �޾ ó���Ѵ�.
		String name= (String)session.getAttribute("ses_name");
		String addr= (String)session.getAttribute("ses_addr");
		System.out.println("----------Controller���� ���� ���� ��: =-------"
				+name+"/"+addr);
		return "session/session_form";
	}//sessionForm
	@RequestMapping(value="/session/session_param.do", method=POST)
	//�ԷµǴ� �Ű������� ���ǿ� �Ҵ��Ѵ�.
	public String sessionParam(SessionVO s_vo, HttpSession session) {
		
		session.setAttribute("ses_name", s_vo.getName());
		session.setAttribute("ses_addr", s_vo.getAddr());
		String url="session/use_session"; //ViewResolver�� ���ؼ� �̵�
		session.setAttribute("flag", "forward�� �̵�");
		if(new Random().nextBoolean()) {
			//ViewResolver�� ������ �ʰ� �̵�
			session.setAttribute("flag", "redirect�� �̵�");
			 url="redirect:use_session.jsp";
		}
		return url;
	}//sessionForm
	
	@RequestMapping(value="/session/remove_session.do",method=GET)
	//������ ���� �� ����
	public String removeSession(HttpSession session) {
		
		session.removeAttribute("ses_name");
		session.removeAttribute("ses_addr");
		session.invalidate();
		
		return "session/session_form";
	}//removeSession
	
	
	
	////////////////////////////////////////////@SessionAttribute�� ����� ����ó��//////////////////////////////////////
	@RequestMapping(value="/session/an_use_session.do", method=GET)
	//���� ���� Controller���� �ޱ�, HttpSession,�� �Ű������� �޾ ó���Ѵ�.
	public String anSessionForm(HttpSession session) {
		String name= (String)session.getAttribute("an_name");
		String addr= (String)session.getAttribute("an_addr");
		
		System.out.println("----------Controller anSessionForm ���� ���� ���� ��: =-------"
				+name+"/"+addr);
		return "session/an_session_form";
	}//sessionForm
	
	@RequestMapping(value="/session/an_session_param.do", method=POST)
	//�ԷµǴ� �Ű������� ���ǿ� �Ҵ��Ѵ�.
	//@SessionArrtibutes annotation�� ����ϸ� ������ ���� �ʰ� Model�� �޴´�.
	public String anSessionParam(SessionVO s_vo, Model model) {
		
		//���ǿ��� ����� ���� Model��ü�� �����Ѵ�.
		//��. �̸��� ������ ������ �̸��� ���ƾ� �������� ���� �Ҵ�ȴ�.
		//����� ���� requestScope�� sessionScope�� �����ϰ� �Ҵ� �ȴ�.
		model.addAttribute("an_name", s_vo.getName());
		model.addAttribute("an_addr", s_vo.getAddr());
		
		String url="session/an_session_value"; //ViewResolver�� ���ؼ� �̵�
		model.addAttribute("an_flag", "forward�� �̵�");
		
		return url;
	}//sessionForm
	
	@RequestMapping(value="/session/an_remove_session.do",method=GET)
	//������ ���� �� ���� (HttpSession�� �Ű������� �޾Ƽ��� @SessionAttribute)
	//�� ������ ���� �������� �ʴ´�.
	//1. SessionStatus ��ü�� �Ű������� �����ϰ�
	public String anRemoveSession(SessionStatus ss) {
		//2. setComplete()�� ȣ���Ͽ� �����Ѵ�.
		ss.setComplete();
		return "session/an_session_form";
	}//removeSession
	
}









