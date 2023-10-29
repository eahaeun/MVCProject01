package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import project.dao.KanrishaDao;
import project.exception.LoginFailException;
import project.model.bean.Kanrisha;

public class LoginService {
private KanrishaDao kanrishaDao = new KanrishaDao();
	
	public Kanrisha login(String kanrisha_uid, String kanrisha_pw) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			Kanrisha kanrisha = kanrishaDao.selectById(conn, kanrisha_uid);
			if(kanrisha == null) {
				throw new LoginFailException();
			}
			if(!kanrisha.matchPassword(kanrisha_pw)) {
				throw new LoginFailException();
			}
			return kanrisha;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
