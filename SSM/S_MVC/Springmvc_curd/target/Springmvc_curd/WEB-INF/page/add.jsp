<%--
  Created by IntelliJ IDEA.
  User: Sleeve
  Date: 2020/1/5
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<h1>员工添加</h1>
<br action="">
    lastName：<input type="text" name="lastName"/><br/>
    email：<input type="text" name="email"/><br/>
    gender：<br/>
        男：<input type="radio" name="gender" value="1"/><br/>
        女：<input type="radio" name="gender" value="0"/><br/>
    dept:
        <select name="department.id">
            <c:forEach items="${depts}" var="deptItem">
                <option value="${deptItem.id}">${deptItem.departmentName}</option>
            </c:forEach>
        </select>
<input type="submit" value="提交"/>
</form>
</body>
</html>
