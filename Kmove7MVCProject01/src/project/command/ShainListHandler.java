package project.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Shain;
import project.model.service.ShainListService;

public class ShainListHandler implements CommandHandler {
	ShainListService shainService = new ShainListService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String listParam = req.getParameter("list");
        // 재직 버튼 클릭시 
        if ("在職者".equals(listParam)) {
        	List<Shain> shainList = shainService.getRetShainList();
        	req.setAttribute("shain", shainList);
            return "/WEB-INF/view/emp/retShainList.jsp";
        }// 퇴직 버튼 클릭시
        else if ("退社者".equals(listParam)) {
        	List<Shain> shainList = shainService.getCurShainList();
        	req.setAttribute("shain", shainList);
            return "/WEB-INF/view/emp/curShainList.jsp";
        } // 전체 버튼 클릭시
        else {
            List<Shain> shainList = shainService.getShainList();
            req.setAttribute("shain", shainList);
            return "/WEB-INF/view/emp/shainList.jsp";
        }
    }
}

