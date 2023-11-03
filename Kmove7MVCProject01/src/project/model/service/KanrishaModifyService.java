package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KanrishaDao;
import project.exception.InvalidPasswordException;
import project.exception.MemberNotFoundException;
import project.model.bean.Kanrisha;

public class KanrishaModifyService {

	private KanrishaDao kanrishaDao = new KanrishaDao();

	public void kanrishaModify(String kanrisha_uid, String curPwd, String newPwd, String newNm) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Kanrisha kanrisha = kanrishaDao.selectById(conn, kanrisha_uid);
			if (kanrisha == null) {
				throw new MemberNotFoundException();
			}
			if (!kanrisha.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			kanrisha.changePassword(newPwd);
			kanrisha.changeName(newNm);
			kanrishaDao.update(conn, kanrisha);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}