package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.K0940_JdbcUtil;
import jdbc.connection.K0950_ConnectionProvider;
import project.dao.K0100_KanrishaDao;
import project.exception.K0700_DuplicatedException;
import project.model.bean.K0110_Kanrisha;
import project.model.request.K0120_JoinRequest;

public class K0131_JoinService {
	//Dao 클래스 인스턴스화
	private K0100_KanrishaDao kanrishaDao = new K0100_KanrishaDao();
	
	public void join(K0120_JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = K0950_ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			//form에 입력된 id로 select. 이미 뭔가 들어있으면 null이 아니니까
			//null이 아닐 시 rollback 후 중복아이디 예외 발생 (논리상 오류 예외처리)
			K0110_Kanrisha kanrisha = kanrishaDao.selectById(conn, joinReq.getKanrisha_uid());
			if(kanrisha != null) {
				K0940_JdbcUtil.rollback(conn);
				throw new K0700_DuplicatedException();
			}
			
			//form에 입력된 id,name,pw를 Kanrisha 객체에 담아 insert 메서드로 db에 삽입
			kanrishaDao.insert(conn, new K0110_Kanrisha(
					joinReq.getKanrisha_uid(),
					joinReq.getKanrisha_pw(),
					joinReq.getKanrisha_nm()));
			conn.commit();
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			K0940_JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			K0940_JdbcUtil.close(conn);
		}
	}
	
}
