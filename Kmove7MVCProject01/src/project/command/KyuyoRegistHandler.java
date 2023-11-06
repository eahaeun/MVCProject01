package project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Shain;
import project.model.request.KyuyoRequest;
import project.model.service.KyuyoRegistService;

public class KyuyoRegistHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/pay/kyuyoCalculate.jsp";
	KyuyoRegistService kyuyoService = new KyuyoRegistService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String shain_no = req.getParameter("shain_number");
		String kizoku_ym = req.getParameter("kizoku_ym");
		int sikyu_pay = Integer.parseInt(req.getParameter("sikyu_pay"));
		int kojyo_pay = Integer.parseInt(req.getParameter("kojyo_pay"));

		// 받아온 사원번호,귀속연월,지급액,공제액을 급여T에 입력
		try {
			kyuyoService.insertPay(shain_no, kizoku_ym, sikyu_pay, kojyo_pay);
			return "/WEB-INF/view/pay/kyuyoRegistSuccess.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return FORM_VIEW;
		}
	}
}
