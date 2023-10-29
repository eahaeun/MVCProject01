package project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.K0960_CommandHandler;

public class K0142_LogoutHandler implements K0960_CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession(false);
		//세션이 존재하면 세션을 종료한다. 세션 종료시 저장된 authUser 속성도 함께 삭제된다.
		if(session != null) {
			session.invalidate();
		}
		return "/WEB-INF/view/main/K0150_login.jsp";
	}

}
