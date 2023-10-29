package project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class KyuyoSearchHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/pay/kyuyoSearch.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return FORM_VIEW;
	}

}
