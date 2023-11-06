//근태 정보를 수정하고 관련된 데이터베이스 작업을 수행하는 클래스
package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.model.bean.Kintai;
import project.model.request.KintaiRequest;

public class KintaiModifyService {
	private KintaiDao kintaiDao = new KintaiDao();
	
	
	//특정 근태 정보를 검색하는 메서드
	public List<Kintai> searchShain(int KINTAI_NO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			List<Kintai> kintaiList = kintaiDao.selectByKintaiNo(conn, KINTAI_NO);
			conn.commit();
			return kintaiList;
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	//근태 정보를 수정하는 메서드
	public void modify(KintaiRequest kinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			//근태 정보를 업데이트하는 데이터베이스 작업 수행
			kintaiDao.update(conn, kinReq.getKINTAI_NO(), kinReq.getKINTAI_KM(), kinReq.getNYUROKU_YMD(),
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
