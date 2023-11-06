package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import project.model.bean.Shain;
import project.model.bean.Taishokusha;

public class TaishokushaDao {
	
	public Taishokusha selectByNo(Connection conn, String shain_no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("select * from taishokusha where shain_no = ?");
			pstmt.setString(1, shain_no);
			rs = pstmt.executeQuery();
			Taishokusha taishokusha = null;
			while (rs.next()) {
				taishokusha = convertTaishokusha(rs);
			}
			return taishokusha;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void insert(Connection conn, Taishokusha taishokusha) throws SQLException {
        try (PreparedStatement pstmt = conn
                .prepareStatement("insert into taishokusha values(?, ?, ?, ?)")) {
            pstmt.setString(1, taishokusha.getShain_no());
            pstmt.setString(2, taishokusha.getTaishoku_jiyu());
            pstmt.setString(3, taishokusha.getTaishoku_renraku());
            pstmt.setInt(4, taishokusha.getTaishoku_pay());
            pstmt.executeUpdate();
        }
    }
	
	private Taishokusha convertTaishokusha(ResultSet rs) throws SQLException {
		return new Taishokusha(
				rs.getString("shain_no"), 
				rs.getString("taishoku_jiyu"), 
				rs.getString("taishoku_renraku"), 
				rs.getInt("taishoku_pay"));
	}
	
	public List<Taishokusha> select(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("select * from taishokusha");
            rs = pstmt.executeQuery();
            List<Taishokusha> result = new ArrayList<>();
            while (rs.next()) {
                result.add(convertTaishokushaList(rs));
            }
            return result;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
	
	public Taishokusha search(Connection conn, String shain_no) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Taishokusha result = null;

        try {
            pstmt = conn.prepareStatement("select * from taishokusha where shain_no = ?");
            pstmt.setString(1, shain_no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = convertTaishokushaList(rs);
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }

        return result;
    }
	
	public Taishokusha update(Connection conn, Taishokusha taishokusha) throws SQLException {
        PreparedStatement pstmt = null;
        Taishokusha result = null;

        try {
            pstmt = conn.prepareStatement(
                    "update taishokusha set taishoku_jiyu = ?, taishoku_renraku = ?, taishoku_pay = ?");
            pstmt.setString(1, taishokusha.getTaishoku_jiyu());
            pstmt.setString(2, taishokusha.getTaishoku_renraku());
            pstmt.setInt(3, taishokusha.getTaishoku_pay());

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                result = taishokusha;
            }
        } finally {
            JdbcUtil.close(pstmt);
        }
        return result;
    }
	
	private Taishokusha convertTaishokushaList(ResultSet rs) throws SQLException {
		return new Taishokusha(
				rs.getString("shain_no"), 
				rs.getString("taishoku_jiyu"), 
				rs.getString("taishoku_renraku"), 
				rs.getInt("taishoku_pay"));
	}

}
