package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.ShainDao;
import project.model.bean.Shain;

public class KintaiListService {
	ShainDao ShainDao = new ShainDao();
		
		public List<Shain> getList() throws SQLException {
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);
				List<Shain> ticketList = ShainDao.select(conn);
				return ticketList;
			} catch(SQLException e) {
				JdbcUtil.rollback(conn);
				return null;
			} finally {
				JdbcUtil.close(conn);
			}
		}
}
