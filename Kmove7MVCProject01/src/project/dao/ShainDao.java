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
		return new Shain(rs.getString("shain_no"), rs.getString("shain_nm"), rs.getString("address"),
				rs.getString("busho_nm"), rs.getString("yakushoku_nm"), rs.getInt("kihon_pay"),
				rs.getString("renraku_tel"), rs.getString("renraku_email"), rs.getDate("nyusha_ymd"),
				rs.getDate("taishoku_ymd"), rs.getString("ginko_nm"), rs.getString("koza_num"),
				rs.getString("zaishoku_st"));
	}

	public List<Shain> select(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from SHAIN_tbl_01 order by SHAIN_NO");
			rs = pstmt.executeQuery();
			List<Shain> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertShain(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void insert(Connection conn, Shain shain) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into shain values(?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?, ?, ?)")) {
			pstmt.setString(1, shain.getShain_no());
			pstmt.setString(2, shain.getShain_nm());
			pstmt.setString(3, shain.getAddress());
			pstmt.setString(4, shain.getBusho_nm());
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
}
