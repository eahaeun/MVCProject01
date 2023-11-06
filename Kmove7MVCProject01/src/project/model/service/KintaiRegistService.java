package project.model.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.model.bean.Kintai;
import project.model.request.KintaiRequest;

public class KintaiRegistService {
	private KintaiDao kintaiDao = new KintaiDao();

	public void add(KintaiRequest regiReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			 int kintaiNo = regiReq.getKINTAI_NO();
		     String shainNo = regiReq.getSHAIN_NO();
			
			kintaiDao.insert(conn, new Kintai(kintaiNo, shainNo, regiReq.getKINTAI_KM(), regiReq.getNYUROKU_YMD(), regiReq.getKAISHI_YMD(), regiReq.getSHURYO_YMD(), regiReq.getKINTAI_PAY()));
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
