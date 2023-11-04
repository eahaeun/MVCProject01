package project.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Kintai;
import project.model.request.KintaiRequest;
import project.model.service.KintaiModifyService;
import project.model.service.KintaiSearchService;

public class KintaiModifyHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/kintai/kintaiModify.jsp";
	KintaiSearchService kinSearchService = new KintaiSearchService();
	KintaiModifyService kinService = new KintaiModifyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String SHAIN_NO = req.getParameter("SHAIN_NO");
		List<Kintai> kintaiList = kinSearchService.getSearchList(SHAIN_NO);
		
		if (kintaiList == null) {
			return "/WEB-INF/view/kintai/kintaiSearch.jsp";
		}
		req.setAttribute("kintai", kintaiList);
		return FORM_VIEW;
	}


	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		KintaiRequest regiReq = new KintaiRequest();
		
		String shain_no = regiReq.getSHAIN_NO();
		Kintai kintai = kinService.searchShain(shain_no);
		req.setAttribute("kintai", kintai);
		
		regiReq.setSHAIN_NO(req.getParameter("SHAIN_NO"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate = LocalDate.parse(req.getParameter("NYUROKU_YMD"), formatter); 
		regiReq.setNYUROKU_YMD(java.sql.Date.valueOf(localDate)); 
		regiReq.setKINTAI_KM(req.getParameter("KINTAI_KM"));
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate2 = LocalDate.parse(req.getParameter("KAISHI_YMD"), formatter2); 
		regiReq.setKAISHI_YMD(java.sql.Date.valueOf(localDate2)); 
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate3 = LocalDate.parse(req.getParameter("SHURYO_YMD"), formatter3); 
		regiReq.setSHURYO_YMD(java.sql.Date.valueOf(localDate3));
		String payValue = req.getParameter("KINTAI_PAY");
		int kintaiPay = Integer.parseInt(payValue);
		regiReq.setKINTAI_PAY(kintaiPay);
		try {
			kinService.modify(regiReq);
			return "/WEB-INF/view/kintai/kintaiModifySuccess.jsp";
		} catch(Exception e) {
			e.printStackTrace();
			return FORM_VIEW;
		}
	}
}
