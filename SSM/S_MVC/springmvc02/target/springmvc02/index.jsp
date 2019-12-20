<%@ page contentType="text/html;charset=UTF-8" language="java"
%>

<html>
<body>
<h2>Hello World!</h2>1
<a href="hello" >hello</a>
<br/>
<a href="handle01?user=tomcat">handle01</a><br/>
<form action="book" method="post">
    书名:<input type="text" name="bookName"/><br/>
    作者:<input type="text" name="author"/><br/>
    价格:<input type="text" name="price"/><br/>
    库存:<input type="text" name="stock"/><br/>
    销量:<input type="text" name="sale"/><br/>
    <hr/>
    作者<br/>
        省：<input type="text" name="address.province"/>
        市：<input type="text" name="address.city"/>
        街道：<input type="text" name="address.street"/>
    <input type="submit">
</form>

</body>
</html>
