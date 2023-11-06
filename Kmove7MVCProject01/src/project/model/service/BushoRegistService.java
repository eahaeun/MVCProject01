package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.BushoDao;
import project.model.bean.Busho;
import project.model.request.BushoRequest;

public class BushoRegistService {

	BushoDao bushoDao = new BushoDao();
	// 부서 등록
	public void regist(BushoRequest regReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			bushoDao.insert(conn, new Busho(regReq.getBusho_nm(), regReq.getTanto_nm(), regReq.getBusho_renraku()));	
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	// 부서 리스트 조회
	public List<Busho> selectList() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			List<Busho> bushoList = bushoDao.select(conn);
			return bushoList;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	 
}
