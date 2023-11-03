package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.ShainDao;
import project.model.bean.Shain;

public class ShainModifyService {
	private ShainDao shainDao = new ShainDao();

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
}