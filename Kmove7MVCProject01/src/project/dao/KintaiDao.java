package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;

public class KintaiDao {

	public String selectByKinNo(Connection conn, String SHAIN_NO) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select tstat from KINTAI_tbl where SHAIN_NO = ?");
			pstmt.setString(1, SHAIN_NO);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("tstat");
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	public int update(Connection conn, String SHAIN_NO, String KINTAI_KM, Date NYUROKU_YMD, Date KAISHI_YMD, Date SHURYO_YMD, int KINTAI_PAY) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(
					"update KINTAI_tbl set tstat=?, SET SHAIN_NO = ?, KINTAI_KM = ?  NYUROKU_YMD = ? KAISHI_YMD = ? SHURYO_YMD = ? KINTAI_PAY = ? where SHAIN_NO=?");
			pstmt.setString(1, SHAIN_NO);
			pstmt.setString(2, KINTAI_KM);
			pstmt.setDate(3, NYUROKU_YMD);
			pstmt.setDate(4, KAISHI_YMD);
			pstmt.setDate(5, SHURYO_YMD);
			pstmt.setInt(6, KINTAI_PAY);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}
