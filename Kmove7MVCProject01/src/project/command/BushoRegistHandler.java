package project.command;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import project.model.bean.Busho;
import project.model.request.BushoRequest;
import project.model.service.BushoRegistService;

public class BushoRegistHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/WEB-INF/view/main/bushoRegist.jsp";
	BushoRegistService bushoService = new BushoRegistService();

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
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		List<Busho> bushoList = bushoService.selectList();
        req.setAttribute("bushoList", bushoList);
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ParseException {	// POST일 경우
	    BushoRequest regReq = new BushoRequest();
	    regReq.setBusho_nm(req.getParameter("busho_nm"));
	    regReq.setTanto_nm(req.getParameter("tanto_nm"));
	    regReq.setBusho_renraku(req.getParameter("busho_renraku"));
	    
	    try {
	        bushoService.regist(regReq);
	        return "WEB-INF/view/main/bushoRegistSuccess.jsp";
	    } catch (Exception e) {
	        return FORM_VIEW;
	    }
	}
}
