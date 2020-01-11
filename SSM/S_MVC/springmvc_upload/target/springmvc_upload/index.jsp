<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" isELIgnored="false"%>

<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<html>
<body>
<h2>Hello World!</h2>

<%--文件上传
    1.文件上传表单准备：enctype=“multipart/form-data
    2.导入fileupload.jar包
    3.javaweb方式非常麻烦
    若是Springmvc：只需要在配置文件中，编写一个配置，配置文件上传解析器（MultipartResolverl）
    4.文件上传请求处理
            在处理器方法上写一个：
              @RequestParam("headering") MultipartFile file，这东西封装了当前文件的信息，可以直接保存--%>
${msg}
<form action="${ctp}}" enctype="multipart/form-data" method="post">
    用户头像：<input name="headering" type="file">
    用户名：<input name="username" type="text">
    <input type="submit">
</form>
</body>
</html>
