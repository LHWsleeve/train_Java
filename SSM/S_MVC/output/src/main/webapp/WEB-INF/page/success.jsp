<%--
  Created by IntelliJ IDEA.
  User: Sleeve
  Date: 2019/12/17
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isErrorPage="true" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>成功</h1>
request:${requestScope.msg}<br/>
<%--没传入的属性不能获取值，会直接报错--%>
<%--pageContxt:${pageContext.msg}<br/>--%>
<%--session:${sessionScope.msg}<br/>--%>
<%--application:${applicationScope.msg}<br/>--%>
</body>
</html>
