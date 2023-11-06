package project.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.request.KintaiRequest;
import project.model.service.KintaiRegistService;
import project.model.service.ShainListService;

public class KintaiRegistHandler implements CommandHandler{
	ShainListService shainService = new ShainListService();
	
	private static final String FORM_VIEW = "/WEB-INF/view/kintai/kintaiRegist.jsp";
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
	//GET 요청 처리
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return FORM_VIEW;	//등록 폼을 보여주는 페이지로 이동
	}
	//POST 요청을 처리, 사용자 입력을 받아 Kintai 정보를 등록하고 결과에 따라 성공 또는 실패 페이지로 리다이렉션
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		KintaiRequest regiReq = new KintaiRequest();
		regiReq.setSHAIN_NO(req.getParameter("shain_no_checkbox"));	//사원 번호 선택
		//입력받은 날짜 문자열을 LocalDate로 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate = LocalDate.parse(req.getParameter("NYUROKU_YMD"), formatter); 
		regiReq.setNYUROKU_YMD(java.sql.Date.valueOf(localDate)); 
		//근태 유형 설정
		regiReq.setKINTAI_KM(req.getParameter("KINTAI_KM"));
		//입력받은 날짜 문자열을 다시 LocalDate로 변환
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate2 = LocalDate.parse(req.getParameter("KAISHI_YMD"), formatter2); 
		regiReq.setKAISHI_YMD(java.sql.Date.valueOf(localDate2)); 
		//입력받은 날짜 문자열을 다시 LocalDate로 변환
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate localDate3 = LocalDate.parse(req.getParameter("SHURYO_YMD"), formatter3); 
		regiReq.setSHURYO_YMD(java.sql.Date.valueOf(localDate3));
		String payValue = req.getParameter("KINTAI_PAY");
		int kintaiPay = Integer.parseInt(payValue);
		regiReq.setKINTAI_PAY(kintaiPay);
		try {
			regiService.add(regiReq);	//Kintai 정보 등록 서비스 호출
			return "/WEB-INF/view/kintai/kintaiRegistSuccess.jsp";	//등록 성공 페이지로 이동
		} catch(Exception e) {
			e.printStackTrace();
			return FORM_VIEW;	// 등록 실패 시 폼 페이지로 다시 이동
		}
	}
}
