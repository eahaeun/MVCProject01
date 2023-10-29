package project.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Shain;
import project.model.bean.Zeikin;
import project.model.request.KyuyoRequest;
import project.model.service.KyuyoCalculateService;

public class KyuyoCalculateHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/pay/kyuyoCalculate.jsp";
	KyuyoCalculateService kyuyoService = new KyuyoCalculateService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			// 응답에 상태코드 전달하는 setStatus 메서드
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		String shain_no = req.getParameter("shain_no");
		Shain shain = kyuyoService.searchShain(shain_no);
		Zeikin zeikin = kyuyoService.calculateZeikin(shain.getKihon_pay());
		
		req.setAttribute("shain", shain);
		req.setAttribute("zeikin", zeikin);
		
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		//급여관련 항목 출력을 위해 req영역에 저장
		KyuyoRequest kyuyoReq = createKyuyoRequest(req);
		int sikyu_pay = kyuyoService.calculateSikyu(kyuyoReq);
		int kojyo_pay = kyuyoService.calculateKojyo(kyuyoReq);
		int sosikyu_pay = sikyu_pay - kojyo_pay;
		
		//사원 테이블 출력을 위해 req영역에 저장
		String shain_no = kyuyoReq.getShain_no();
		Shain shain = kyuyoService.searchShain(shain_no);
		req.setAttribute("shain", shain);
		
		req.setAttribute("kyuyoReq", kyuyoReq);
		req.setAttribute("sikyu_pay", sikyu_pay);
		req.setAttribute("kojyo_pay", kojyo_pay);
		req.setAttribute("sosikyu_pay", sosikyu_pay);
		
		return "/WEB-INF/view/pay/kyuyoRegist.jsp";
	}
	
	//지급,공제항목들 정수로 변환 후 req객체에 담음
	private KyuyoRequest createKyuyoRequest(HttpServletRequest req) {
		String shain_no = req.getParameter("shain_number");
		String kizoku_ym = req.getParameter("kizoku_ym");
		int kihon_pay = Integer.parseInt(req.getParameter("kihon_pay"));
		int kintai_pay = Integer.parseInt(req.getParameter("kintai_pay"));
		int shoku_pay = Integer.parseInt(req.getParameter("shoku_pay"));
		int nenkin = Integer.parseInt(req.getParameter("nenkin"));
		int kenko = Integer.parseInt(req.getParameter("kenko"));
		int koyo = Integer.parseInt(req.getParameter("koyo"));
		int shotoku = Integer.parseInt(req.getParameter("shotoku"));
		int etc = Integer.parseInt(req.getParameter("etc"));
		
		return new KyuyoRequest(shain_no,kizoku_ym,kihon_pay,kintai_pay,shoku_pay,nenkin,kenko,koyo,shotoku,etc);
	}
}
