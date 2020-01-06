<%--
  Created by IntelliJ IDEA.
  User: Sleeve
  Date: 2020/1/5
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<html>
<head>
    <title>员工列表页面</title>
</head>
<body>
<h1>员工列表 </h1>
<table border="1" cellpadding="5px" cellspacing="0px">
  </th>
    <th>ID</th>
    <th>lastName</th>
    <th>Email</th>
    <th>gender</th>
    <th>departmentName</th>
    <th>Edit</th>
    <th>DELETE</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
    <tr>
        <td>${emp.id}</td>
        <td>${emp.lastName}</td>
        <td>${emp.email}</td>
        <td>${emp.gender==0?"女":"男"}</td>
        <td>${emp.department.departmentName}</td>
        <td>
            <a href="${ctp}/emp/${emp.id}">Edit</a>
        </td>
        <td>
            <form action="${ctp}/emp/${emp.id}" method="post">
                <input type="hidden" name="_method" value="DELETE"/>
                <input type="submit" value="删除">
            </form>
        </td>
    </c:forEach>
</table>
<a href="toaddpage">添加员工</a>
</body>
</html>
