package project.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Shain;
import project.model.service.ShainModifyService;

public class ShainModifyHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/emp/shainModify.jsp";
	ShainModifyService shainService = new ShainModifyService();

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
		Shain shain = shainService.searchShain(shain_no);

		req.setAttribute("shain", shain);

		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws SQLException, ParseException {
		String shain_no = req.getParameter("shain_no");

		// 기존의 Shain 객체를 가져와서 수정하기
		Shain shain = shainService.searchShain(shain_no);

		// 수정할 내용을 파라미터에서 읽어와서 Shain 객체에 설정
		shain.setShain_nm(req.getParameter("shain_nm"));
		shain.setAddress(req.getParameter("address"));
		shain.setBusho_nm(req.getParameter("busho_nm"));
		shain.setYakushoku_nm(req.getParameter("yakushoku_nm"));
		String noval = req.getParameter("kihon_pay");
		int kihon_pay = Integer.parseInt(noval);
		shain.setKihon_pay(kihon_pay);
		shain.setRenraku_tel(req.getParameter("renraku_tel"));
		shain.setRenraku_email(req.getParameter("renraku_email"));
		SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd");
		String str = req.getParameter("nyusha_ymd");
		Date nyusha_ymd = start.parse(str);
		shain.setNyusha_ymd(nyusha_ymd);
		String str1 = req.getParameter("taishoku_ymd");
		Date taishoku_ymd = start.parse(str1);
		shain.setTaishoku_ymd(taishoku_ymd);
		shain.setGinko_nm(req.getParameter("ginko_nm"));
		shain.setKoza_num(req.getParameter("koza_num"));
		// Shain 객체를 업데이트
		shain = shainService.update(shain);

		req.setAttribute("shain", shain);

		return "/WEB-INF/view/emp/shainModifySuccess.jsp";
	}
}
