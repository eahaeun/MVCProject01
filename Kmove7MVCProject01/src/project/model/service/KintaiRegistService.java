//근태 정보를 등록하고 데이터베이스 작업릉 수행하는 클래스
package project.model.service;

import java.sql.Connection;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.model.bean.Kintai;
import project.model.request.KintaiRequest;

public class KintaiRegistService {
	private KintaiDao kintaiDao = new KintaiDao();

	//근태 정보를 추가하는 메서드
	public void add(KintaiRequest regiReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//KintaiRequest에서 필요한 정보 추출
			 int kintaiNo = regiReq.getKINTAI_NO();
		     String shainNo = regiReq.getSHAIN_NO();
			//근태 정보를 데이터베이스에 추가
			kintaiDao.insert(conn, new Kintai(kintaiNo, shainNo, regiReq.getKINTAI_KM(), regiReq.getNYUROKU_YMD(), regiReq.getKAISHI_YMD(), regiReq.getSHURYO_YMD(), regiReq.getKINTAI_PAY()));
			conn.commit();
		} catch(Exception e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
	}
	//근태 정보의 총 수를 조회하는 메서드
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
