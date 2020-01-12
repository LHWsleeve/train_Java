<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" isELIgnored="false"%>

<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<html>
<body>
<%
    System.out.format("success.jsp....");

%>>
<h2>Hello World!</h2>
<a href="${ctp}/test01">test01</a>
</body>
</html>
