package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KyuyoDao;
import project.model.bean.KyuyoList;

public class KyuyoListService {
	KyuyoDao kyuyoDao = new KyuyoDao();

	public List<KyuyoList> getKyuyoList() throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<KyuyoList> kyuyoList = kyuyoDao.select(conn);
			conn.commit();
			return kyuyoList;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
