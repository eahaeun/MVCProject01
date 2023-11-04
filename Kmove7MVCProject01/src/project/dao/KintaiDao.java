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
import project.model.bean.KyuyoList;

public class KintaiDao {

	public int insert(Connection conn, Kintai kintai) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"insert into kintai values (?,?,(TO_CHAR(?,'RRMMDD')),(TO_CHAR(?,'RRMMDD')),(TO_CHAR(?,'RRMMDD')),?)");
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

	public Kintai selectByKinNo(Connection conn, String SHAIN_NO) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select tstat from KINTAI where SHAIN_NO = ?");
			pstmt.setString(1, SHAIN_NO);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return null;
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int update(Connection conn, String SHAIN_NO, String KINTAI_KM, Date NYUROKU_YMD, Date KAISHI_YMD,
			Date SHURYO_YMD, int KINTAI_PAY) throws SQLException {
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

	// 휴일급여 조회
	public int selectPay(Connection conn, String shain_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select SUM(kintai_pay) AS total_kintai_pay from kintai where shain_no=?");
			pstmt.setString(1, shain_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("total_kintai_pay");
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
