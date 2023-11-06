package project.command;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.TaishokushaDao;
import project.model.bean.Taishokusha;
import project.model.request.TaishokuRequest;

public class TaishokushaRegistService {
	private TaishokushaDao taishokushaDao = new TaishokushaDao();

	public void taishoku(TaishokuRequest taishokuReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			taishokushaDao.insert(conn, new Taishokusha(
					taishokuReq.getShain_no(),
					taishokuReq.getTaishoku_jiyu(),
					taishokuReq.getTaishoku_renraku(), 
					taishokuReq.getTaishoku_pay()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
