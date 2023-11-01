package project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.service.KyuyoManageService;

public class KyuyoDeleteHandler implements CommandHandler {
	KyuyoManageService kyuyoService = new KyuyoManageService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String shain_no = req.getParameter("shain_no");
		String kizoku_ym = req.getParameter("kizoku_ym");
		req.getSession().setAttribute("shain_no", shain_no);
		kyuyoService.deleteKyuyo(kizoku_ym, shain_no);
		return "/WEB-INF/view/pay/kyuyoDeleteSuccess.jsp";
	}
}
