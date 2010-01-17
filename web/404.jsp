<%
String contextPath = request.getContextPath();
String url = contextPath + "/index.html";
response.sendRedirect(url);
%>
