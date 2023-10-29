package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import project.model.bean.Kyuyo;
import project.model.bean.KyuyoList;

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

	// 급여대장 조회
	public List<KyuyoList> select(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT kizoku_ym, COUNT(DISTINCT shain_no) AS shain_count, SUM(sikyu_pay) AS total_sikyu_pay, SUM(kojyo_pay) AS total_kojyo_pay FROM kyuyo GROUP BY kizoku_ym ORDER BY kizoku_ym DESC");
			rs = pstmt.executeQuery();
			List<KyuyoList> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertKyuyoList(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private KyuyoList convertKyuyoList(ResultSet rs) throws SQLException {
		return new KyuyoList(rs.getString("kizoku_ym"),
		        rs.getInt("shain_count"),
		        rs.getInt("total_sikyu_pay"),
		        rs.getInt("total_kojyo_pay")						
		    );
	}
}
