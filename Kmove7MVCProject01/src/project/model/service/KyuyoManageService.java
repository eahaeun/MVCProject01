package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KyuyoDao;
import project.dao.ShainDao;
import project.model.bean.Kyuyo;
import project.model.bean.Shain;

public class KyuyoManageService {
	KyuyoDao kyuyoDao = new KyuyoDao();
	ShainDao shainDao = new ShainDao();
	
	public List<Kyuyo> getKyuyo(String shain_no) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Kyuyo> kyuyo = kyuyoDao.select(conn, shain_no);
			conn.commit();
			return kyuyo;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Shain getShain(String shain_no) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Shain shain = shainDao.selectByNo(conn, shain_no);
			conn.commit();
			return shain;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public void deleteKyuyo(String kizoku_ym, String shain_no) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			kyuyoDao.drop(conn, kizoku_ym, shain_no);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
