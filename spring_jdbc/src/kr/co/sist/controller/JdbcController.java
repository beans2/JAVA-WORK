package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;

import kr.co.sist.service.JdbcService;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
@Controller
public class JdbcController {
	
	@Autowired
	private JdbcService js;
	
	@RequestMapping(value="/index.do",method= {GET,POST})
	public String test() {
		js.daoPrint();
		return "index";
	}//test
	
	@RequestMapping(value="add_form.do", method=GET)
	public String memberUploadForm() {
		return "member/add_form";
	}//memberUpload
	
	@RequestMapping(value="/addmember_process.do",method=POST)
	public String uploadProcess(HttpServletRequest request) {
		String moveURL="redirect:err.html";
		try {
			if(js.fileuploadProcess(request)) {
				moveURL="member/upload_success";
			}//end if
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return moveURL;
	}//uploadProcess
	
}//class
