package project.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.exception.DuplicatedException;
import project.model.bean.Busho;
import project.model.request.ShainRequest;
import project.model.service.ShainRegistService;

public class ShainRegistHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/emp/shainRegist.jsp";
	private ShainRegistService shainRegistService = new ShainRegistService();

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
	// GET 요청 처리
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		
		List<Busho> bushoList = shainRegistService.selectBusho();
		req.setAttribute("bushoList", bushoList);
		return FORM_VIEW;
	}
	// POST 요청 처리
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		List<Busho> bushoList = shainRegistService.selectBusho();
		req.setAttribute("bushoList", bushoList);
		// 웹에서 입력된 데이터를 shainRequest에 저장
		ShainRequest shainReq = new ShainRequest();
		shainReq.setShain_no(req.getParameter("shain_no"));
		shainReq.setShain_nm(req.getParameter("shain_nm"));
		SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd");
		String str = req.getParameter("nyusha_ymd");
		Date nyusha_ymd = start.parse(str);
		shainReq.setNyusha_ymd(nyusha_ymd);
		shainReq.setAddress(req.getParameter("address"));
		shainReq.setBusho_nm(req.getParameter("busho_nm"));
		shainReq.setYakushoku_nm(req.getParameter("yakushoku_nm"));
		shainReq.setRenraku_tel(req.getParameter("renraku_tel"));
		shainReq.setRenraku_email(req.getParameter("renraku_email"));
		String noval = req.getParameter("kihon_pay");
		int kihon_pay = Integer.parseInt(noval);
		shainReq.setKihon_pay(kihon_pay*10000);
		shainReq.setGinko_nm(req.getParameter("ginko_nm"));
		shainReq.setKoza_num(req.getParameter("koza_num"));
		shainReq.setZaishoku_st("在職");
		
		try {
			shainRegistService.shain(shainReq); //Shain 등록 메서드 호출
			return "/WEB-INF/view/emp/shainRegistSuccess.jsp";
		} catch (DuplicatedException e) {
			return FORM_VIEW; // 예외 발생 시에는 등록 폼으로 돌아간다.
		}

	}

}
