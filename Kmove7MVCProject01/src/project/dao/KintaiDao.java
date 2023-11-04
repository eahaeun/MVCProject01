package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import project.model.bean.Kintai;

public class KintaiDao {

	public int insert(Connection conn, Kintai kintai) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into kintai values (?,?,(TO_CHAR(?,'RRMMDD')),(TO_CHAR(?,'RRMMDD')),(TO_CHAR(?,'RRMMDD')),?)");
			pstmt.setString(1, kintai.getSHAIN_NO());
			pstmt.setString(2, kintai.getKINTAI_KM());
			pstmt.setDate(3, kintai.getNYUROKU_YMD());
			pstmt.setDate(4, kintai.getKAISHI_YMD());
			pstmt.setDate(5, kintai.getSHURYO_YMD());
			pstmt.setInt(6, kintai.getKINTAI_PAY());
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from shain");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	public List<Kintai> selectByShainNo(Connection conn, String SHAIN_NO) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from KINTAI where SHAIN_NO = ?");
			pstmt.setString(1, SHAIN_NO);
			rs = pstmt.executeQuery();
			List<Kintai> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertKintai(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int update(Connection conn, String SHAIN_NO, String KINTAI_KM, Date NYUROKU_YMD, Date KAISHI_YMD, Date SHURYO_YMD, int KINTAI_PAY) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(
					"update KINTAI SET KINTAI_KM = ?  NYUROKU_YMD = ? KAISHI_YMD = ? SHURYO_YMD = ? KINTAI_PAY = ? where SHAIN_NO=?");
			pstmt.setString(1, KINTAI_KM);
			pstmt.setDate(2, NYUROKU_YMD);
			pstmt.setDate(3, KAISHI_YMD);
			pstmt.setDate(4, SHURYO_YMD);
			pstmt.setInt(5, KINTAI_PAY);
			pstmt.setString(6, SHAIN_NO);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	private Kintai convertKintai(ResultSet rs) throws SQLException {
		return new Kintai(rs.getString("SHAIN_NO"), rs.getString("KINTAI_KM"), rs.getDate("NYUROKU_YMD"), rs.getDate("KAISHI_YMD"),
				rs.getDate("SHURYO_YMD"), rs.getInt("KINTAI_PAY"));
	}

	
}
