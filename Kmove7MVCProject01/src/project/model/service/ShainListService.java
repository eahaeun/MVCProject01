package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.ShainDao;
import project.model.bean.Shain;
import project.model.request.ShainRequest;
// 직원 정보 조회
public class ShainListService {
	ShainDao shainDao = new ShainDao();
	
	public List<Shain> getShainList() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Shain> shainList = shainDao.select(conn);
			conn.commit();
			return shainList;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	//재직
	public List<Shain> getRetShainList() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Shain> shainList = shainDao.retselect(conn);
			conn.commit();
			return shainList;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	//퇴직
	public List<Shain> getCurShainList() throws SQLException{
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Shain> shainList = shainDao.curselect(conn);
			conn.commit();
			return shainList;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
