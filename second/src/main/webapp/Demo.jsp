<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.Model.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>You login Successfully</h1>
<%! 
Users u;
%>
   <% 
    u=(Users)session.getAttribute("currentUser");
   
  
    %>
    <h1>The login Successfully <%=u.getName() %></h1>

</body>
</html>