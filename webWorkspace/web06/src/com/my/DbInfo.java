package com.my;

public class DbInfo {

	public static String driver="oracle.jdbc.driver.OracleDriver";
	public static String url="jdbc:oracle:thin:@localhost:1521:xe";
	public static String user=System.getenv("Oracle_id");
	public static String password=System.getenv("Oracle_pw");
	
}
