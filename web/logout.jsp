<%
session.removeAttribute("name");
session.invalidate();
response.sendRedirect("login.jsp");
%>
