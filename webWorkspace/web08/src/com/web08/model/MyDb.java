package com.web08.model;

import java.sql.Connection;
import java.sql.SQLException;

public class MyDb {
	private static Connection conn;
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	//scott, tiger도 이후엔 System.getenv()로 환경변수에서 불러오기
	private static String user="scott";
	private static String password="tiger";
	//default 생성자도 private 으로
	private MyDb() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//conn이 없거나 close 였다면 새로운 객체 생성
		if(conn==null || conn.isClosed()) {
			Class.forName(driver);
			conn= java.sql.DriverManager.getConnection(url,user,password);
		}
		return conn;
	}
}
