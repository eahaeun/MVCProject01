package project.command;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.exception.DuplicatedException;
import project.model.request.TaishokuRequest;
import project.model.service.TaishokushaRegistService;

public class TaishokushaRegistHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/retire/taishokuRegist.jsp";
	private TaishokushaRegistService taishokushaRegistService = new TaishokushaRegistService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}
		if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		String shain_no = req.getParameter("shain_no");
		req.setAttribute("shain_no", shain_no);
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		TaishokuRequest taishokuReq = new TaishokuRequest();
		taishokuReq.setShain_no(req.getParameter("shain_no"));
		taishokuReq.setTaishoku_jiyu(req.getParameter("taishoku_jiyu"));
		taishokuReq.setTaishoku_renraku(req.getParameter("taishoku_renraku"));
		System.out.println(req.getParameter("shain_no"));
		String noval = req.getParameter("taishoku_pay");
		int taishoku_pay = Integer.parseInt(noval);
		taishokuReq.setTaishoku_pay(taishoku_pay);
		
		try {
			taishokushaRegistService.updateStatement(taishokuReq);
			taishokushaRegistService.taishoku(taishokuReq);
			return "/WEB-INF/view/retire/taishokuRegistSuccess.jsp";
		} catch (DuplicatedException e) {
			return FORM_VIEW; 
		}

	}

}
