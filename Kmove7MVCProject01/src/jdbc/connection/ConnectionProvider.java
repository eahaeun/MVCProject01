package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		//DBCP가 제공하는 PoolingDriver를 통해 커넥션 풀로부터 커넥션을 가져오기
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:board");
	}
}
