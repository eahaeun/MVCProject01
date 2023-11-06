//근태 정보와 사원 정보를 조회하는 서비스를 제공하는 클래스
package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.dao.ShainDao;
import project.model.bean.Kintai;
import project.model.bean.Shain;

public class KintaiListService {
	ShainDao shainDao = new ShainDao();
	KintaiDao kintaiDao = new KintaiDao();

	//모든 사원 목록을 조회하는 메서드
	public List<Shain> getShainList() throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Shain> shainList = shainDao.select(conn);
			conn.commit();
			return shainList;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	// 재직중인 직원 목록을 조회하는 메서드
	public List<Shain> getRetShainList() throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Shain> shainList = shainDao.retselect(conn);
			conn.commit();
			return shainList;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	//특정 직원의 근태 목록을 조회하는 메서드
	public List<Kintai> getKintaiList(String shain_no) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Kintai> kintaiList = kintaiDao.selectByShainNo(conn, shain_no);
			conn.commit();
			return kintaiList;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
