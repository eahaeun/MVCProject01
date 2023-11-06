package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import project.model.bean.Kyuyo;
import project.model.bean.KyuyoDetail;
import project.model.bean.KyuyoList;

public class KyuyoDao {

	// 급여 목록 삽입 메서드
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

	// 급여목록 조회
	public List<Kyuyo> select(Connection conn, String shain_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from kyuyo where shain_no = ? order by kizoku_ym desc");
			pstmt.setString(1, shain_no);
			rs = pstmt.executeQuery();
			List<Kyuyo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertKyuyo(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 급여 테이블 삭제
	public int drop(Connection conn, String kizoku_ym, String shain_no) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from kyuyo where kizoku_ym=? and shain_no=?")) {
			pstmt.setString(1, kizoku_ym);
			pstmt.setString(2, shain_no);
			return pstmt.executeUpdate();
		}
	}

	// 급여대장 조회
	public List<KyuyoList> select(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT kizoku_ym, COUNT(DISTINCT shain_no) AS shain_count, SUM(sikyu_pay) AS total_sikyu_pay, SUM(kojyo_pay) AS total_kojyo_pay FROM kyuyo GROUP BY kizoku_ym ORDER BY kizoku_ym DESC");
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

	// 급여 상세 조회
	public List<KyuyoDetail> selectByYM(Connection conn, String kizoku_ym) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select shain_nm, nyusha_ymd, busho_nm, yakushoku_nm, kihon_pay, sikyu_pay, kojyo_pay "
							+ "from kyuyo inner join shain on kyuyo.shain_no = shain.shain_no "
							+ "where kyuyo.kizoku_ym = ? order by shain_nm");
			pstmt.setString(1, kizoku_ym);
			rs = pstmt.executeQuery();
			List<KyuyoDetail> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertKyuyoDetail(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// 급여 목록 변환 메서드
	private KyuyoList convertKyuyoList(ResultSet rs) throws SQLException {
		return new KyuyoList(rs.getString("kizoku_ym"), rs.getInt("shain_count"), rs.getInt("total_sikyu_pay"),
				rs.getInt("total_kojyo_pay"));
	}

	// 급여 변환 메서드
	private Kyuyo convertKyuyo(ResultSet rs) throws SQLException {
		return new Kyuyo(rs.getString("shain_no"), rs.getString("kizoku_ym"), rs.getInt("sikyu_pay"),
				rs.getInt("kojyo_pay"));
	}

	// 급여 상세 변환 메서드
	private KyuyoDetail convertKyuyoDetail(ResultSet rs) throws SQLException {
		return new KyuyoDetail(rs.getString("shain_nm"), toSDF(rs.getTimestamp("nyusha_ymd")), rs.getString("busho_nm"),
				rs.getString("yakushoku_nm"), rs.getInt("kihon_pay"), rs.getInt("sikyu_pay"), rs.getInt("kojyo_pay"));
	}

	// 날짜 변환 메서드
	private String toSDF(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(timestamp.getTime()));
	}
}