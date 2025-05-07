<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*, java.util.*, java.net.URLEncoder" %>
<%
request.setCharacterEncoding("UTF-8");
String keyword = request.getParameter("keyword");
String pageStr = request.getParameter("page");

int currentPage = 1;
if (pageStr != null && !pageStr.trim().equals("")) {
    currentPage = Integer.parseInt(pageStr);
}
int pageSize = 10;
int offset = (currentPage - 1) * pageSize;

String url = "jdbc:mysql://localhost:33306/xe";
String user = "scott";
String password = "tiger";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String keywordSafe = (keyword != null) ? URLEncoder.encode(keyword, "UTF-8") : "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, password);

    String sql = "SELECT * FROM board";
    boolean hasKeyword = (keyword != null && !keyword.trim().equals(""));
    if (hasKeyword) {
        sql += " WHERE subject LIKE ?";
    }
    sql += " ORDER BY ref DESC, ord ASC LIMIT ?, ?";
    pstmt = conn.prepareStatement(sql);

    int paramIndex = 1;
    if (hasKeyword) {
        pstmt.setString(paramIndex++, "%" + keyword + "%");
    }
    pstmt.setInt(paramIndex++, offset);
    pstmt.setInt(paramIndex, pageSize);
    rs = pstmt.executeQuery();
%>
<html>
<table>
  <thead>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>날짜</th>
    </tr>
  </thead>
<%
  while(rs.next()) {
    int num = rs.getInt("num");
    String subject = rs.getString("subject");
    String writer = rs.getString("id");
    java.sql.Date nalja = rs.getDate("nalja");
    int lvl = rs.getInt("lvl");
%>
  <tbody>
    <tr>
      <td><%= num %></td>
      <td>
        <% for (int i = 0; i < lvl; i++) { %> └ <% } %>
        <%= subject %>
      </td>
      <td><%= writer %></td>
      <td><%= nalja %></td>
    </tr>
  </tbody>
<% 
} 
%>
</table>

<div>
  <% if (currentPage > 1) { %>
    <a href="#" class="page-link" data-page="<%= currentPage - 1 %>">이전</a>
  <% } %>
  <a href="#" class="page-link" data-page="<%= currentPage + 1 %>">다음</a>
</div>
</html>
<%
} catch(Exception e) {
    out.println("<p style='color:red;'>오류: " + e.getMessage() + "</p>");
    e.printStackTrace();
} finally {
    try { if (rs != null) rs.close(); } catch (Exception e) {}
    try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
    try { if (conn != null) conn.close(); } catch (Exception e) {}
}
%>