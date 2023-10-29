package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import project.model.bean.Kyuyo;

public class KyuyoDao {
	
	// 데이터 삽입 메서드
	public void insert(Connection conn, Kyuyo kyuyo) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into kyuyo values (?,?,?,?)");
			pstmt.setString(1, kyuyo.getShain_no());
			pstmt.setString(2, kyuyo.getKizoku_ym());
			pstmt.setInt(3, kyuyo.getSikyu_pay());
			pstmt.setInt(4, kyuyo.getKojyo_pay());
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
