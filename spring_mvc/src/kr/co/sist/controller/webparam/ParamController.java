package kr.co.sist.controller.webparam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {
	//GET방식으로 요청을 처리할 때에는 URL만 넣어도 된다.
	//value="URL",method=RequestMethod.GET
	@RequestMapping(value="/request_form.do")
	public String requestForm() {
		
		return "param/request_form";
	}//requestForm
	
	@RequestMapping(value="use_request_process.do",method=GET)
	//HttpServletRequest를 사용한 파라메터 처리:권장x
	public String requestFormProcess(HttpServletRequest request) {
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String[] lang=request.getParameterValues("lang");
		
		System.out.println(name+" "+age+" "+Arrays.toString(lang));
		request.setAttribute("lang", lang);
		
		return "param/request_process";
	}//requestFormProcess
	
	@RequestMapping(value="/vo_form.do")
	public String voForm() {
		
		return "param/vo_form";
	}
	//VO를 사용한 Parameter처리.
	@RequestMapping(value="vo_process.do", method=GET)
	public String voProcess(ParamVO pv, Model m) {
		m.addAttribute("langData",pv.getLang());//이 값은 JSP로 전달된다.
		m.addAttribute("nameData",pv.getName());//이 값은 JSP로 전달된다.
		m.addAttribute("ageData",pv.getAge());//이 값은 JSP로 전달된다.
		return "param/vo_process";
	}
	
	@RequestMapping(value="/request_string.do", method=GET)
	//단일형으로 매개변수를 받을 때에는 web parameter명과 method의 매개변수명이 
	//같아야한다.
	public String requestString(@RequestParam(defaultValue="anonymous")String name,Model m) {
//		if(name==null||"".equals(name)) { //파라메터 자체가 없을 때
//			//파라메터는 존재하나 값이 없을 때
//			name="guest";
//		}//end if
		m.addAttribute("name",name+"님 안녕하세요?");
		return "param/string_param";
	}//requestString
	
	@RequestMapping(value="/request_int.do", method=GET)
	public String requestInt(@RequestParam(name="age", defaultValue="1") int age, Model m) {
		
		m.addAttribute("age",age+"살");
		return "param/int_param";
	}//requestString
	
}
