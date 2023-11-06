package project.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Shain;
import project.model.service.ShainListService;

public class KintaiListHandler implements CommandHandler {
	//ShainListService 인스턴스 생성
	ShainListService shainService = new ShainListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ShainListService를 사용해 사원 목록을 가져옴
		List<Shain> shainList = shainService.getRetShainList();
		req.setAttribute("shain", shainList);
		return "/WEB-INF/view/kintai/kintaiRegist.jsp";
	}

}
