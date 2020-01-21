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
%>

<script type="text/javascript" src="scripts/jquery-3.4.1.min.js"></script>

<html>
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
<br/>
<form action="${cpt}/testRequestBody2" method="post" enctype="multipart/form-data">
    <input name="username2" value="tomcat"/>
    <input name="password2" value="123456"/>
    <input name="file2" type="file"/>
    <input type="submit"/>
</form>

</body>
<a href="${cpt}/testRequestBody2">ajax发送json数据</a>
<script type="text/javascript">
    $("a:first").click(function () {
        //1.点击发送AJAX请求，请求带的数据是jason
        var emp = {lastName:"张三",email:"111@qqq.com",gender:"0"};
        //js对象
        var empStr = JSON.stringify(emp);
        $.ajax({
            url:"${cpt}/testRequestBody2",
            type:"POST",
            data:empStr,
            contentType:"application/json",
            success:function (data) {
                // console.log(data);
                alert(data);
                }
        });
        return false;
    });
</script>
</html>
