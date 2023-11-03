package project.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.exception.InvalidPasswordException;
import project.exception.MemberNotFoundException;
import project.model.bean.Kanrisha;
import project.model.service.KanrishaModifyService;

public class KanrishaModifyHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/kanrishaModify.jsp";
	private KanrishaModifyService kmodService = new KanrishaModifyService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Kanrisha kanrisha = (Kanrisha) req.getSession().getAttribute("authUser");

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		String newNm = req.getParameter("newNm");

		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if (newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		if (newNm == null || newNm.isEmpty()) {
			errors.put("newNm", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			kmodService.kanrishaModify(kanrisha.getKanrisha_uid(), curPwd, newPwd, newNm);
			return "/WEB-INF/view/main/kanrishaModifySuccess.jsp";
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}