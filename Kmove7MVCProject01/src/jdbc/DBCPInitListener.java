package jdbc;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


public class DBCPInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//웹 애플리케이션이 시작될 때 생성된 ServletContext 객체를 추출하고
		//web.xml에 설정한 모든 서블릿에서 사용할 수 있는 파라미터 값(context-param) 받아오기
		String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
		Properties prop = new Properties();
		try {
			//키=값으로 구성된 문자열로부터 프로퍼티 로딩
			prop.load(new StringReader(poolConfig));
		} catch(IOException e) {
			//contextInitialized()의 메서드 정의에 throws가 없어서
			//checked 아니고 unchecked 지정해야 하기 때문에 runtime예외 혹은 그 하위타입 예외 발생시키기
			throw new RuntimeException(e);
		}
		loadJDBCDriver(prop);
		initConnectionPool(prop);
	}
	
	//드라이버 로딩
	private void loadJDBCDriver(Properties prop) {
		String driverClass = prop.getProperty("jdbcdriver");
		try {
			Class.forName(driverClass);
		} catch(ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver",ex);
		}
	}
	
	//커넥션 풀 초기화
	private void initConnectionPool(Properties prop) {
		try {
			String jdbcUrl=prop.getProperty("jdbcUrl");
			String username=prop.getProperty("dbUser");
			String pw = prop.getProperty("dbPass");
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl,username,pw);
			
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory,null);
			String validationQuery = prop.getProperty("validationQuery");
			if(validationQuery!=null && validationQuery.isEmpty()) {
				poolableConnFactory.setValidationQuery("validationQuery");
			}
			
			//커넥션 풀 설정 정보 생성
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			int minIdle = getIntProperty(prop,"minIdle",5);
			poolConfig.setMinIdle(minIdle);
			int maxTotal = getIntProperty(prop,"maxTotal",50);
			poolConfig.setMaxTotal(maxTotal);
			
			//커넥션 풀 생성
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,poolConfig);
			//팩토리에 생성한 커넥션 풀 연결
			poolableConnFactory.setPool(connectionPool);
			
			//커넥션 풀 사용할 jdbc 드라이버 등록
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = prop.getProperty("poolName");
			
			//커넥션 풀 드라이버에 커넥션 풀 등록
			driver.registerPool(poolName, connectionPool);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//정수형으로 변환하는 메서드
	private int getIntProperty(Properties prop, String propName, int defaultValue) {
		String value = prop.getProperty(propName);
		if(value == null) return defaultValue;
		return Integer.parseInt(value);
	}
}