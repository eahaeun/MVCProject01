package project.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Kintai;
import project.model.service.KintaiListService;

public class KintaiListHandler implements CommandHandler {
	KintaiListService kintaiService = new KintaiListService();

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

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		String shain_no = req.getParameter("shain_no");

		List<Kintai> kintaiList = kintaiService.getKintaiList(shain_no);
		req.setAttribute("kintaiList", kintaiList);
		return "/WEB-INF/view/kintai/kintaiList.jsp";
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String shain_no = req.getParameter("shain_no");

		List<Kintai> kintaiList = kintaiService.getKintaiList(shain_no);
		req.setAttribute("kintaiList", kintaiList);
		return "/WEB-INF/view/kintai/kintaiList.jsp";
	}

}
