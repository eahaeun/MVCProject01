package project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class TaishokushaSearchHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/WEB-INF/view/retire/taishokuSearch.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return FORM_VIEW;
	}

}
