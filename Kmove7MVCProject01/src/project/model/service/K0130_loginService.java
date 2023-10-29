package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.K0950_ConnectionProvider;
import project.dao.K0100_KanrishaDao;
import project.exception.K0701_LoginFailException;
import project.model.bean.K0110_Kanrisha;

public class K0130_loginService {
private K0100_KanrishaDao kanrishaDao = new K0100_KanrishaDao();
	
	public K0110_Kanrisha login(String kanrisha_uid, String kanrisha_pw) {
		try(Connection conn = K0950_ConnectionProvider.getConnection()) {
			K0110_Kanrisha kanrisha = kanrishaDao.selectById(conn, kanrisha_uid);
			if(kanrisha == null) {
				throw new K0701_LoginFailException();
			}
			if(!kanrisha.matchPassword(kanrisha_pw)) {
				throw new K0701_LoginFailException();
			}
			return kanrisha;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
