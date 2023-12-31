package project.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Kyuyo;
import project.model.bean.Shain;
import project.model.service.KyuyoManageService;

public class KyuyoManageHandler implements CommandHandler {
	KyuyoManageService kyuyoService = new KyuyoManageService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String shain_no = req.getParameter("shain_no");
		
		//받아온 사원번호로 그 사원의 급여이력과 사원정보 불러오기
		List<Kyuyo> kyuyo = kyuyoService.getKyuyo(shain_no);
		Shain shain = kyuyoService.getShain(shain_no);
		req.setAttribute("kyuyo", kyuyo);
		req.setAttribute("shain", shain);
		return "/WEB-INF/view/pay/kyuyoManage.jsp";
	}
}
