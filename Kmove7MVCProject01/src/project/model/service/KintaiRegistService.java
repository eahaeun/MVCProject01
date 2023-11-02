package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.dao.ShainDao;
import project.model.bean.Kintai;
import project.model.bean.Shain;
import project.model.request.KintaiRequest;

public class KintaiRegistService {
	private KintaiDao kintaiDao = new KintaiDao();
	private ShainDao shainDao = new ShainDao();
	
	public Shain searchShain(String shain_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			Shain shain = shainDao.selectByNo(conn, shain_no);
			conn.commit();
			return shain;
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public void add(KintaiRequest regiReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			kintaiDao.insert(conn, new Kintai(
					regiReq.getKINTAI_KM(),
					regiReq.getNYUROKU_YMD(),
					regiReq.getKAISHI_YMD(),
					regiReq.getSHURYO_YMD(),
					regiReq.getKINTAI_PAY()));
			conn.commit();
		} catch(Exception e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
	}
	public int count() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			int result = kintaiDao.selectCount(conn);
			conn.commit();
			return result;
		} catch(Exception e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			return -1;
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
