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
			//�� ȯ���� context �� java�� ������ �ִ� context�� ���� 
			Context envCtxt= (Context) initctxt.lookup("java:/comp/env");
			//context.xml���� ������ name �� 'jdbc/TestDB' �� dataSource ����
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
			//���⼭�� close�� IO�� �ݴ� ���� �ƴ϶� ��ȯ�ϴ� ��(connection pool�̴ϱ�)
			if(conn!=null) conn.close();
		}
		
		return list;
	}
}
