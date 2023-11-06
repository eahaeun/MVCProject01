package project.command;

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
		String shain_no = req.getParameter("shain_no");

		List<Kintai> kintaiList = kintaiService.getKintaiList(shain_no);
		req.setAttribute("kintaiList", kintaiList);
		return "/WEB-INF/view/kintai/kintaiList.jsp";
	}

}
