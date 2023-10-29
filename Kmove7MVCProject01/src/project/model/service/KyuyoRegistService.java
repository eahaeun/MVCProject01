package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KyuyoDao;
import project.model.bean.Kyuyo;

public class KyuyoRegistService {
	private KyuyoDao kyuyoDao = new KyuyoDao();
	
	public void insertPay(String shain_no, String kizoku_ym, int sikyu_pay, int kojyo_pay) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			kyuyoDao.insert(conn, new Kyuyo(shain_no,kizoku_ym,sikyu_pay,kojyo_pay));
			conn.commit();
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
