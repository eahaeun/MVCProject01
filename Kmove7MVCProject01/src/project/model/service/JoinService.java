package project.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.KanrishaDao;
import project.exception.DuplicatedException;
import project.model.bean.Kanrisha;
import project.model.request.JoinRequest;

public class JoinService {
	//Dao 클래스 인스턴스화
	private KanrishaDao kanrishaDao = new KanrishaDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			//트랜잭션 시작
			conn.setAutoCommit(false);
			
			//form에 입력된 id로 select. 이미 뭔가 들어있으면 null이 아니니까
			//null이 아닐 시 rollback 후 중복아이디 예외 발생 (논리상 오류 예외처리)
			Kanrisha kanrisha = kanrishaDao.selectById(conn, joinReq.getKanrisha_uid());
			if(kanrisha != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicatedException();
			}
			
			//form에 입력된 id,name,pw를 Kanrisha 객체에 담아 insert 메서드로 db에 삽입
			kanrishaDao.insert(conn, new Kanrisha(
					joinReq.getKanrisha_uid(),
					joinReq.getKanrisha_pw(),
					joinReq.getKanrisha_nm()));
			conn.commit();
		} catch(SQLException e) {
			//실행상 오류가 발생하면 RuntimeException 예외 발생
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
