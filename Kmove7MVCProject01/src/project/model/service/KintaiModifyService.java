package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.model.bean.Kintai;
import project.model.request.KintaiRequest;

public class KintaiModifyService {
	private KintaiDao kintaiDao = new KintaiDao();
	
	
	
	public Kintai searchShain(String SHAIN_NO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			Kintai kintai = kintaiDao.selectByShainNo(conn, SHAIN_NO);
			conn.commit();
			return kintai ;
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public void modify(KintaiRequest kinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			kintaiDao.update(conn, kinReq.getSHAIN_NO(), kinReq.getKINTAI_KM(), kinReq.getNYUROKU_YMD(),
					kinReq.getKAISHI_YMD(), kinReq.getSHURYO_YMD(), kinReq.getKINTAI_PAY());
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}


}
