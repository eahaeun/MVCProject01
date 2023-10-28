package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.K0960_CommandHandler;
import mvc.command.K0961_NullHandler;

public class K0970_ControllerUsingURI extends HttpServlet {
	private Map<String, K0960_CommandHandler> commandHandlerMap = new HashMap<>();
	
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		//초기화 매개변수
		Properties prop = new Properties();
		//String의 키와 값을 가짐
		String configFilePath = getServletContext().getRealPath(configFile);
		try(FileReader fr = new FileReader(configFilePath)) {
			prop.load(fr); //Properties객체에 키와 값 로드
		} catch(IOException e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		//키값들을 keyIter로 읽어오기
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			//command에 key 하나 불러와서 (Object->String 형변환)
			String handlerClassName = prop.getProperty(command);
			//불러온 그 key의 value를 handlerClassName 변수에 저장함
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				Constructor<?> constructor = handlerClass.getConstructor();
				K0960_CommandHandler handlerInstance = (K0960_CommandHandler) constructor.newInstance();
				//해당 핸들러 클래스를 인스턴스화
				commandHandlerMap.put(command, handlerInstance);
				//인스턴스화 된 실제 핸들러 클래스를 다시 key랑 묶어서 map에 넣음
			} catch(Exception e) {
				throw new ServletException(e);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		String command = req.getRequestURI();
		// command에 들어가있는 건 "/프로젝트이름/파일명"
		if(command.indexOf(req.getContextPath()) == 0) {
			//getContextPath()의 결과는 "/프로젝트명/" 0번부터 있는지 검증하기 위한 if문
			command = command.substring(req.getContextPath().length());
			//6번부터 추출하기 위함
		}
		
		K0960_CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
			handler = new K0961_NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
			//포워딩할 페이지 반환받아서
		} catch(Exception e) {
			throw new ServletException(e);
		}
		if(viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
			//포워딩 해주기
		}
	}
}
