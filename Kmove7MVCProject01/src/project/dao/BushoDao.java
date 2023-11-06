package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import project.model.bean.Busho;

public class BushoDao {

	public void insert(Connection conn, Busho busho) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into busho values(?,?,?)")) {
			pstmt.setString(1, busho.getBusho_nm());
			pstmt.setString(2, busho.getTanto_nm());
			pstmt.setString(3, busho.getBusho_renraku());
			pstmt.executeUpdate();
		}
	}

	public List<Busho> select(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from busho");
			rs = pstmt.executeQuery();
			List<Busho> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertBusho(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Busho convertBusho(ResultSet rs) throws SQLException {
		return new Busho(rs.getString("busho_nm"), 
				rs.getString("tanto_nm"), 
				rs.getString("busho_renraku"));
	}
	
	
}