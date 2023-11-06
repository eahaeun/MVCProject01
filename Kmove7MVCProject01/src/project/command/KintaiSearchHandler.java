package project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
//근태검색을 처리
public class KintaiSearchHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/kintai/kintaiSearch.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return FORM_VIEW;	//검색 폼을 표시하기 위한 jsp 뷰 페이지의 경로를 반환
	}

}
