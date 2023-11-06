package project.command;

import java.io.IOException;
import java.sql.SQLException;
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
	
	//GET 요청 처리
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noValue = req.getParameter("KINTAI_NO");
		int kintaiNo = Integer.parseInt(noValue);

		List<Kintai> kintaiList = kinSearchService.getSearchList(kintaiNo);
		
		if (kintaiList == null) {
			return "/WEB-INF/view/kintai/kintaiSearch.jsp";
		}
		req.setAttribute("kintai", kintaiList);
		return FORM_VIEW;
	}

	//POST 요청 처리
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		KintaiRequest regiReq = new KintaiRequest();
		
		//KINTAI_NO 파라미터를 가져와 정수로 변환
		int kintai_no = regiReq.getKINTAI_NO();
		List<Kintai> kintai = kinService.searchShain(kintai_no);
		req.setAttribute("kintai", kintai);
		
		String noValue = req.getParameter("KINTAI_NO");
		int kintaiNO = Integer.parseInt(noValue);
		regiReq.setKINTAI_NO(kintaiNO);
		//날짜 문자열을 파싱하여 날짜 형식으로 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate = LocalDate.parse(req.getParameter("NYUROKU_YMD"), formatter); 
		regiReq.setNYUROKU_YMD(java.sql.Date.valueOf(localDate)); 
		//다른 필드들도 위의 경우와 비슷하게 처리
		regiReq.setKINTAI_KM(req.getParameter("KINTAI_KM"));
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate2 = LocalDate.parse(req.getParameter("KAISHI_YMD"), formatter2); 
		regiReq.setKAISHI_YMD(java.sql.Date.valueOf(localDate2)); 
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate3 = LocalDate.parse(req.getParameter("SHURYO_YMD"), formatter3); 
		regiReq.setSHURYO_YMD(java.sql.Date.valueOf(localDate3));
		//KINTAI_PAY 파라미터를 가져와 정수로 변환
		String payValue = req.getParameter("KINTAI_PAY");
		int kintaiPay = Integer.parseInt(payValue);
		regiReq.setKINTAI_PAY(kintaiPay);
		try {
			kinService.modify(regiReq);	//Kintai 수정 메서드 호출
			return "/WEB-INF/view/kintai/kintaiModifySuccess.jsp";	//성공 시의 jsp 경로 반환
		} catch(Exception e) {
			e.printStackTrace();
			return FORM_VIEW;	//예외 발생 시에는 수정 폼으로 돌아감
		}
	}
}
