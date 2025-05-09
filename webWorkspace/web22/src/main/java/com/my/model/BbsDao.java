package com.my.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BbsDao {
	DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BbsDao() {
		try {
			Context initctxt= new InitialContext();
			//내 환경의 context 를 java에 지정돼 있는 context를 얻어내서 
			Context envCtxt= (Context) initctxt.lookup("java:/comp/env");
			//context.xml에서 지정한 name 인 'jdbc/TestDB' 로 dataSource 얻어내기
			dataSource= (DataSource) envCtxt.lookup("jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<BbsDto> selectAll() throws SQLException {
		String sql="select * from bbs order by num desc";
		List<BbsDto> list=new ArrayList<>();
		
		try {
			conn=dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BbsDto(
						rs.getInt("num"),rs.getString("sub")
						,rs.getString("content"),rs.getString("id")
						,rs.getTimestamp("nalja")
						));
			}
		} finally {
			//여기서의 close는 IO를 닫는 것이 아니라 반환하는 것(connection pool이니까)
			if(conn!=null) conn.close();
		}
		
		return list;
	}
}
