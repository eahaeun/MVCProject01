package project.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.KyuyoDetail;
import project.model.service.KyuyoDetailService;

public class KyuyoDetailHandler implements CommandHandler {
	KyuyoDetailService kyuyoService = new KyuyoDetailService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String kizoku_ym = req.getParameter("kizoku_ym");
		List<KyuyoDetail> kyuyoDetail = kyuyoService.getKyuyoDetail(kizoku_ym);
		req.setAttribute("kyuyoDetail", kyuyoDetail);
		req.setAttribute("kizoku_ym", kizoku_ym);
		return "/WEB-INF/view/pay/kyuyoDetail.jsp";
	}

}
