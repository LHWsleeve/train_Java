<%@ page contentType="text/html;charset=UTF-8" language="java"
%>

<html>
<body>
<h2>Hello World!</h2>
<br/>
<a href="/hello">Hello</a><br/>
<%--SpringMVC如何给页面携带数据--%>
<a href="handle01">handle01</a><br/>
<a href="handle02">handle02</a><br/>
<a href="handle03">handle03</a><br/>
<a href="/handle04">handle04</a><br/>
<h1>修改图书-不能修改书名：</h1>
<form action="/updateBook" method="post">
    <input type="hidden" name="id" value="100"/>
    书名:西游记<br/>
    作者: <input type="text" name="author"/><br/>
    价格: <input type="text" name="price"/><br/>
    库存: <input type="text" name="stock"/><br/>
    销量: <input type="text" name="sales"/><br/>
<input type="submit" value="修改图书"/>
</form>
</body>
</html>
