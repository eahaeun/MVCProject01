package project.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.exception.LoginFailException;
import project.model.bean.Kanrisha;
import project.model.service.LoginService;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/main/login.jsp";
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = trim(req.getParameter("kanrisha_uid"));
		String password = trim(req.getParameter("kanrisha_pw"));

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		// 아이디 혹은 패스워드가 비어있을 시 errors에 (프로퍼티명, TRUE)추가
		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);
		
		// errors에 추가된 값이 있으면 login 창으로 돌아감
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			Kanrisha kanrisha = loginService.login(id, password);
			// 세션 영역에 로그인 정보 저장
			req.getSession().setAttribute("authUser", kanrisha);
			// 메인 페이지로 이동
			return "/WEB-INF/view/main/mainpage.jsp";
		} catch (LoginFailException e) {
			// 아이디와 패스워드 불일치시 errors에 추가
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	// 공백제거
	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
