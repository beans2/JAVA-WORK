package ko.co.sist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	/**
	 * ��û,����ó��, �������� ��ü(Session, Cookie)�� ���
	 * @param rsquest �� �Ķ���� ��ûó��
	 * @param response ����ó��
	 * @throws ServletException 
	 * @throws IOException
	 */
	public void execute(HttpServletRequest rsquest, HttpServletResponse response) 
		throws ServletException,IOException;
	
	/**
	 * ó���� ����� ������ JSP���� ��ȯ
	 * @return
	 */
	public String moveURL();
	
	/**
	 * ó���� ����� ������ JSP, HTML�� �̵��ϴ� �̵���� ����
	 * @return
	 */
	public boolean isForward();
	
}//Controller
