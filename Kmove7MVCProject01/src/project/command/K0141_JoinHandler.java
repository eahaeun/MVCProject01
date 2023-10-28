package project.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.K0960_CommandHandler;
import project.exception.K0700_DuplicatedException;
import project.model.request.K0120_JoinRequest;
import project.model.service.K0131_JoinService;

public class K0141_JoinHandler implements K0960_CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/K0151_join.jsp";
	private K0131_JoinService joinService = new K0131_JoinService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req,res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req,res);
		} else {
			//응답에 상태코드 전달하는 setStatus 메서드
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		//joinFrom.jsp로 포워딩
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		//form에 입력된 정보 받아오기
		K0120_JoinRequest joinReq = new K0120_JoinRequest();
		joinReq.setKanrisha_uid(req.getParameter("kanrisha_uid"));
		joinReq.setKanrisha_pw(req.getParameter("kanrisha_pw"));
		joinReq.setKanrisha_nm(req.getParameter("kanrisha_nm"));
		joinReq.setConfirm_pw(req.getParameter("comfirm_pw"));
		
		//Map 생성 후 request 영역에 errors라는 이름으로 저장
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
	
		//빈칸, 비번확인하는 메서드 실행 한 후
		joinReq.validate(errors);
		
		//error에 뭔가 put된게 있으면 회원가입 페이지로 돌려보내
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			//joinService의 join이 Dao의 insert를 호출함
			joinService.join(joinReq);
			//joinSuccess.jsp로 포워딩
			return "/WEB-INF/view/main/K0152_joinSuccess.jsp";
		} catch(K0700_DuplicatedException e) {
			//중복 아이디가 존재하면 Map에 put
			errors.put("duplicatedId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
