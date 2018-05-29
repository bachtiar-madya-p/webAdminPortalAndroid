<%
session.removeAttribute("uname");
session.invalidate();
response.sendRedirect("login_sa.jsp");
%>
