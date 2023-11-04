package project.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KintaiDao;
import project.dao.ShainDao;
import project.model.bean.Shain;
import project.model.bean.Zeikin;
import project.model.request.KyuyoRequest;

public class KyuyoCalculateService {
	private ShainDao shainDao = new ShainDao();
	private KintaiDao kintaiDao = new KintaiDao();
	
	public Shain searchShain(String shain_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			Shain shain = shainDao.selectByNo(conn, shain_no);
			conn.commit();
			return shain;
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public int getKintaiPay(String shain_no) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			int kintai_pay = kintaiDao.selectPay(conn, shain_no);
			conn.commit();
			return kintai_pay;
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Zeikin calculateZeikin(int kihon_pay) {
		int nenkin = (int)(kihon_pay*0.045);
		int kenko = (int)(kihon_pay*0.0399);
		int koyo = (int)(kihon_pay*0.009);
		return new Zeikin(nenkin,kenko,koyo);
	}
	
	public int calculateSikyu(KyuyoRequest kyuyoReq) {
		return kyuyoReq.getKihon_pay() + kyuyoReq.getKintai_pay() + kyuyoReq.getShoku_pay();
	}
	
	public int calculateKojyo(KyuyoRequest kyuyoReq) {
		return kyuyoReq.getNenkin() + kyuyoReq.getKenko() + kyuyoReq.getKoyo() + kyuyoReq.getShotoku() + kyuyoReq.getEtc();
	}
}
