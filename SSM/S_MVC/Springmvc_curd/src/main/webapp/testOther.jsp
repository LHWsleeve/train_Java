<%--
  Created by IntelliJ IDEA.
  User: Sleeve
  Date: 2020/1/11
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" isELIgnored="false"%>
<%
    pageContext.setAttribute("cpt",request.getContextPath());
%><html>
<head>
    <title>Title</title>
</head>
<body>
<%--只有post提交才有请求体--%>
<form action="${cpt}/testRequestBody" method="post" enctype="multipart/form-data">
<input name="username" value="tomcat"/>
<input name="password" value="123456"/>
<input name="file" type="file"/>
<input type="submit"/>
</form>
</body>
</html>
