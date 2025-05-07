package com.mvc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.util.Mysql;

public class BbsDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public List<com.mvc.model.BbsDto> selectAll() {
		java.util.List<BbsDto> list = new java.util.ArrayList<>();

		String sql = "select * from board order by ref desc,ord asc";

		try {
			stmt = Mysql.getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BbsDto bean = new BbsDto();
				bean.setNum(rs.getInt("num"));
				bean.setSub(rs.getString("subject"));
				bean.setId(rs.getString("id"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setLvl(rs.getInt("lvl"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if (rs != null)rs.close();
					if (stmt != null)stmt.close();
					if (Mysql.getConnection() != null)Mysql.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}

}
