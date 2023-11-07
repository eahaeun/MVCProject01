package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.BushoDao;
import project.dao.ShainDao;
import project.model.bean.Busho;
import project.model.bean.Shain;
import project.model.request.ShainRequest;
// 직원 정보 등록
public class ShainRegistService {
	private ShainDao shainDao = new ShainDao();
	private BushoDao bushoDao = new BushoDao();
	
	public void shain(ShainRequest shainReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
//			Shain shain = shainDao.selectByNo(conn, shainReq.getShain_no());
//			if(shain != null) {
//				JdbcUtil.rollback(conn);
//				throw new DuplicatedException();
//			}
			
			shainDao.insert(conn, new Shain(
				    shainReq.getShain_no(),
				    shainReq.getShain_nm(),
				    shainReq.getAddress(),
				    shainReq.getBusho_nm(),
				    shainReq.getYakushoku_nm(),
				    shainReq.getKihon_pay(),
				    shainReq.getRenraku_tel(),
				    shainReq.getRenraku_email(),
				    shainReq.getNyusha_ymd(),
				    shainReq.getTaishoku_ymd(),
				    shainReq.getGinko_nm(),
				    shainReq.getKoza_num(),
				    shainReq.getZaishoku_st()
				));
			
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
	
	public List<Busho> selectBusho() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			List<Busho> bushoList = bushoDao.select(conn);
			conn.commit();
			return bushoList;
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
