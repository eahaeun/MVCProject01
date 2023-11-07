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
// 직원 정보 수정
public class ShainModifyService {
	private ShainDao shainDao = new ShainDao();
	private BushoDao bushoDao = new BushoDao();

	public Shain searchShain(String shain_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();

			Shain shain = shainDao.seaselect(conn, shain_no); // 올바른 메서드명으로 수정
			return shain;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Shain update(Shain shain) {
	    Connection conn = null;
	    Shain updatedShain = null;
	    try {
	        conn = ConnectionProvider.getConnection();
	        updatedShain = shainDao.update(conn, shain);
	    } catch (SQLException e) {
	        // SQLException 처리
	        e.printStackTrace(); // 또는 다른 오류 처리 방식
	    } finally {
	        JdbcUtil.close(conn);
	    }
	    
	    return updatedShain;
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