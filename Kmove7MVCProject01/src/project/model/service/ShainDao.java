package project.model.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import project.model.bean.Shain;

public class ShainDao {
	public Shain selectByNo(Connection conn, String shain_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from shain where shain_no = ?");
			pstmt.setString(1, shain_no);
			rs = pstmt.executeQuery();
			Shain shain = null;
			if (rs.next()) {
				shain = convertShain(rs);
			}
			return shain;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Shain convertShain(ResultSet rs) throws SQLException {
		return new Shain(
				rs.getString("shain_no"),
				rs.getString("shain_nm"),
				rs.getString("address"),
				rs.getString("busho_nm"),
				rs.getString("yakushoku_nm"),
				rs.getInt("kihon_pay"),
				rs.getString("renraku_tel"),
				rs.getString("renraku_email"),
				rs.getDate("nyusha_ymd"),
				rs.getDate("taishoku_ymd"),
				rs.getString("ginko_nm"),
				rs.getString("koza_num"),
				rs.getString("zaishoku_st")
				);
	}
}