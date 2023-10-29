package project.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.K0960_CommandHandler;
import project.exception.K0701_LoginFailException;
import project.model.bean.K0110_Kanrisha;
import project.model.service.K0130_loginService;

public class K0140_LoginHandler implements K0960_CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/main/K0150_login.jsp";
	private K0130_loginService loginService = new K0130_loginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		//joinFrom.jsp로 포워딩
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = trim(req.getParameter("kanrisha_uid"));
		String password = trim(req.getParameter("kanrisha_pw"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if(id==null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if(password==null || password.isEmpty())
			errors.put("password", Boolean.TRUE);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			K0110_Kanrisha kanrisha = loginService.login(id, password);
			req.getSession().setAttribute("authUser", kanrisha);
			return "/WEB-INF/view/main/K0800_mainpage.jsp";
		} catch(K0701_LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	
	//공백제거
	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
