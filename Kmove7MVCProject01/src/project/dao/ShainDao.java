package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import project.model.bean.Shain;

public class ShainDao {
	// 사원 번호로 검색
	public Shain selectByNo(Connection conn, String shain_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from shain where shain_no = ?");
			pstmt.setString(1, shain_no);
			rs = pstmt.executeQuery();
			Shain shain = null;
			while (rs.next()) {
				shain = convertShain(rs);
			}
			return shain;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	// 사원 등록
	public void insert(Connection conn, Shain shain) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into shain values(?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?, ?, ?)")) {
			pstmt.setString(1, shain.getShain_no());
			pstmt.setString(2, shain.getShain_nm());
			pstmt.setString(3, shain.getAddress());
			pstmt.setString(4, shain.getBusho_nm().trim());
			pstmt.setString(5, shain.getYakushoku_nm());
			pstmt.setInt(6, shain.getKihon_pay());
			pstmt.setString(7, shain.getRenraku_tel());
			pstmt.setString(8, shain.getRenraku_email());
			pstmt.setTimestamp(9, new Timestamp(shain.getNyusha_ymd().getTime()));
			pstmt.setString(10, shain.getGinko_nm());
			pstmt.setString(11, shain.getKoza_num());
			pstmt.setString(12, shain.getZaishoku_st());
			pstmt.executeUpdate();
		}
	}
	
	private Shain convertShain(ResultSet rs) throws SQLException {
		return new Shain(rs.getString("shain_no"), rs.getString("shain_nm"), rs.getString("address"),
				rs.getString("busho_nm"), rs.getString("yakushoku_nm"), rs.getInt("kihon_pay"),
				rs.getString("renraku_tel"), rs.getString("renraku_email"), rs.getDate("nyusha_ymd"),
				rs.getDate("taishoku_ymd"), rs.getString("ginko_nm"), rs.getString("koza_num"),
				rs.getString("zaishoku_st"));
	}

	// 전체 사원 목록 조회
	public List<Shain> select(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from shain");
			rs = pstmt.executeQuery();
			List<Shain> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertShainList(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 재직상태가 재직인 사원목록 조회
	public List<Shain> retselect(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM shain WHERE zaishoku_st = '在職'");
			rs = pstmt.executeQuery();
			List<Shain> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertShainList(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 재직상태가 퇴직인 사원목록 조회
	public List<Shain> curselect(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT * FROM shain WHERE zaishoku_st = '退社'");
			rs = pstmt.executeQuery();
			List<Shain> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertShainList(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	// 사원 검색
	public Shain seaselect(Connection conn, String shain_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shain result = null;

		try {
			pstmt = conn.prepareStatement("SELECT * FROM shain WHERE shain_no = ?");
			pstmt.setString(1, shain_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = convertShainList(rs);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return result;
	}
	// 사원 정보 수정
	public Shain update(Connection conn, Shain shain) throws SQLException {
		PreparedStatement pstmt = null;
		Shain result = null;

		try {
			pstmt = conn.prepareStatement(
					"UPDATE shain SET shain_nm = ?, address = ?, busho_nm = ?, yakushoku_nm = ?, kihon_pay = ?, renraku_tel = ?, renraku_email = ?, nyusha_ymd = ?, taishoku_ymd = ?, ginko_nm = ?, koza_num = ? WHERE shain_no = ?");
			pstmt.setString(1, shain.getShain_nm());
			pstmt.setString(2, shain.getAddress());
			pstmt.setString(3, shain.getBusho_nm());
			pstmt.setString(4, shain.getYakushoku_nm());
			pstmt.setInt(5, shain.getKihon_pay());
			pstmt.setString(6, shain.getRenraku_tel());
			pstmt.setString(7, shain.getRenraku_email());
			pstmt.setTimestamp(8, new Timestamp(shain.getNyusha_ymd().getTime()));
			pstmt.setTimestamp(9, new Timestamp(shain.getTaishoku_ymd().getTime()));
			pstmt.setString(10, shain.getGinko_nm());
			pstmt.setString(11, shain.getKoza_num());
			pstmt.setString(12, shain.getShain_no());

			int rowsUpdated = pstmt.executeUpdate();

			if (rowsUpdated > 0) {
				result = shain;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	private Shain convertShainList(ResultSet rs) throws SQLException {
		return new Shain(rs.getString("shain_no"), rs.getString("shain_nm"), rs.getString("address"),
				rs.getString("busho_nm"), rs.getString("yakushoku_nm"), rs.getInt("kihon_pay"),
				rs.getString("renraku_tel"), rs.getString("renraku_email"), rs.getDate("nyusha_ymd"),
				rs.getDate("taishoku_ymd"), rs.getString("ginko_nm"), rs.getString("koza_num"),
				rs.getString("zaishoku_st"));
	}

	// 데이터 수정
	public int updateStatement(Connection conn, String shain_no) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("UPDATE shain SET zaishoku_st = '退職' WHERE shain_no=?")) {
			pstmt.setString(1, shain_no);
			return pstmt.executeUpdate();
		}
	}
}
