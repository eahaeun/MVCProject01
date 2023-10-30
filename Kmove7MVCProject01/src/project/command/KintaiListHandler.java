package project.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Shain;
import project.model.service.KintaiListService;

public class KintaiListHandler implements CommandHandler{

	KintaiListService listService = new KintaiListService();
		
		@Override
		public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

			List<Shain> shainList = listService.getList();
			req.setAttribute("ticketList", shainList);
			return "/WEB-INF/view/kintaiList..jsp";
		}
	
	
}
