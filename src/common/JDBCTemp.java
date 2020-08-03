package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemp {
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties p = new Properties();
		try {
//			Class.forName("orcle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			String cp = JDBCTemp.class.getResource("./").getPath();
			p.load(new FileReader(cp + "jdbc.properties"));
			
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String passwd = p.getProperty("passwd");
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,passwd);
			conn.setAutoCommit(false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	

	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
