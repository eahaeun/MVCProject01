package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KyuyoDao;
import project.model.bean.KyuyoDetail;

public class KyuyoDetailService {
	KyuyoDao kyuyoDao = new KyuyoDao();

	public List<KyuyoDetail> getKyuyoDetail(String kizoku_ym) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<KyuyoDetail> kyuyoDetail = kyuyoDao.selectByYM(conn, kizoku_ym);
			conn.commit();
			return kyuyoDetail;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
