//근태 데이터베이스 테이블과 상호작용하는 DAO클래스
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

	//Kintai 테이블에 새로운 레코드를 삽입하는 메서드
	public int insert(Connection conn, Kintai kintai) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"insert into kintai values (kintai_seq.nextval,?,?,(TO_CHAR(?,'RRMMDD')),(TO_CHAR(?,'RRMMDD')),(TO_CHAR(?,'RRMMDD')),?)");
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

	//테이블의 레코드 수를 반환하는 메서드
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

	//사원 번호에 따른 Kintai정보를 조회하는 메서드
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

	//Kintai 번호에 따른 Kintai 정보를 조회하는 메서드
	public List<Kintai> selectByKintaiNo(Connection conn, int KINTAI_NO) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from KINTAI where KINTAI_NO = ?");
			pstmt.setInt(1, KINTAI_NO);
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

	//Kintai 정보를 수정하는 메서드
	public int update(Connection conn, int KINTAI_NO, String KINTAI_KM, Date NYUROKU_YMD, Date KAISHI_YMD,
			Date SHURYO_YMD, int KINTAI_PAY) throws SQLException {
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(
					"update KINTAI SET KINTAI_KM = ?  NYUROKU_YMD = ? KAISHI_YMD = ? SHURYO_YMD = ? KINTAI_PAY = ? where KINTAI_NO=?");
			pstmt.setString(1, KINTAI_KM);
			pstmt.setDate(2, NYUROKU_YMD);
			pstmt.setDate(3, KAISHI_YMD);
			pstmt.setDate(4, SHURYO_YMD);
			pstmt.setInt(5, KINTAI_PAY);
			pstmt.setInt(6, KINTAI_NO);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	//ResultSet에서 Kintai 객체로 변환하는 메서드
	private Kintai convertKintai(ResultSet rs) throws SQLException {
		return new Kintai(rs.getInt("KINTAI_NO"), rs.getString("SHAIN_NO"), rs.getString("KINTAI_KM"),
				rs.getDate("NYUROKU_YMD"), rs.getDate("KAISHI_YMD"), rs.getDate("SHURYO_YMD"), rs.getInt("KINTAI_PAY"));
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
