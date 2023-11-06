//근태정보를 검색하는 서비스를 제공하는 클래스
package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.model.bean.Kintai;

public class KintaiSearchService {
	KintaiDao kintaiDao = new KintaiDao();
	
	//특정 근태 번호에 해당하는 근태 정보를 검색하는 메서드
	public List<Kintai> getSearchList(int KINTAI_NO) throws SQLException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			List<Kintai> kintaiList = kintaiDao.selectByKintaiNo(conn, KINTAI_NO);
			conn.commit();	
			return kintaiList;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			return null;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
