package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.TaishokushaDao;
import project.model.bean.Taishokusha;

public class TaishokushaSearchService {
	private TaishokushaDao taishokushaDao = new TaishokushaDao();

	public Taishokusha searchTaishokusha(String shain_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();

			Taishokusha taishokusha = taishokushaDao.search(conn, shain_no);
			return taishokusha;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}