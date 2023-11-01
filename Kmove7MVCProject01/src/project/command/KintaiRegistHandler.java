package project.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.service.KintaiRegistService;
import project.model.service.KintaiRequest;

public class KintaiRegistHandler implements CommandHandler{

	private static final String FORM_VIEW = "/WEB-INF/view/kintaiRegist.jsp";
	private KintaiRegistService regiService = new KintaiRegistService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("count",regiService.count());
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String noVal = req.getParameter("shain_no");
		int no = Integer.parseInt(noVal);
		KintaiRequest regiReq = new KintaiRequest();
		regiReq.setKINTAI_KM(req.getParameter("KINTAI_KM"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate = LocalDate.parse(req.getParameter("NYUROKU_YMD"), formatter); 
		regiReq.setNYUROKU_YMD(java.sql.Date.valueOf(localDate)); 
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate2 = LocalDate.parse(req.getParameter("KAISHI_YMD"), formatter2); 
		regiReq.setKAISHI_YMD(java.sql.Date.valueOf(localDate)); 
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate3 = LocalDate.parse(req.getParameter("SHURYO_YMD"), formatter3); 
		regiReq.setSHURYO_YMD(java.sql.Date.valueOf(localDate));
		String payValue = req.getParameter("KINTAI_PAY");
		int kintaiPay = Integer.parseInt(payValue);
		regiReq.setKINTAI_PAY(kintaiPay);
		try {
			regiService.add(regiReq);
			return "/WEB-INF/view/kintaiRegistSuccess.jsp";
		} catch(Exception e) {
			e.printStackTrace();
			return FORM_VIEW;
		}
	}
}
