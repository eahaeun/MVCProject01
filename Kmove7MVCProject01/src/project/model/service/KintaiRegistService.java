package project.model.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.model.bean.Kintai;

public class KintaiRegistService {
	private KintaiDao kintaiDao = new KintaiDao();

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
}
