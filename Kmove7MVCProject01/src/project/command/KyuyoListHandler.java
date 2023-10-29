package project.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.KyuyoList;
import project.model.service.KyuyoListService;

public class KyuyoListHandler implements CommandHandler {
	KyuyoListService kyuyoService = new KyuyoListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<KyuyoList> kyuyoList = kyuyoService.getKyuyoList();
		req.setAttribute("kyuyoList", kyuyoList);
		return "/WEB-INF/view/pay/kyuyoList.jsp";
	}
}
