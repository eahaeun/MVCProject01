package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.K0940_JdbcUtil;
import project.model.bean.K0110_Kanrisha;

public class K0100_KanrishaDao {
	public K0110_Kanrisha selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from kanrisha where kanrisha_uid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			K0110_Kanrisha kanrisha = null;
			if (rs.next()) {
				kanrisha = new K0110_Kanrisha(rs.getString("kanrisha_uid"), rs.getString("kanrisha_pw"),
						rs.getString("kanrisha_nm"));
			}
			return kanrisha;
		} finally {
			K0940_JdbcUtil.close(rs);
			K0940_JdbcUtil.close(pstmt);
		}
	}

	// 데이터 삽입 메서드
	public void insert(Connection conn, K0110_Kanrisha kanrisha) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into kanrisha values(?,?,?)")) {
			pstmt.setString(1, kanrisha.getKanrisha_uid());
			pstmt.setString(2, kanrisha.getKanrisha_pw());
			pstmt.setString(3, kanrisha.getKanrisha_nm());
			pstmt.executeUpdate();
		}
	}
}
