package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.model.bean.Kintai;

public class KintaiSearchService {
	KintaiDao kintaiDao = new KintaiDao();
	
	public List<Kintai> getSearchList(String SHAIN_NO) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Kintai> kintaiList = kintaiDao.selectByShainNo(conn, SHAIN_NO);
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
