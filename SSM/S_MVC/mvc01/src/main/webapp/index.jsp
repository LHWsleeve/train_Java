<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="hello">index页面</a>
<h1>ResquestMapping测试</h1>
<a href="/handle01">test01-写在方法上的ResquestMapping测试</a>
<br/>
<a href="haha/handle01">test01-写在l类上的ResquestMapping测试</a>
<br/>
<h1>测试ResquestMapping的属性</h1>
<a href="/haha/handle02">handle02</a><br/>
<form action="/haha/handle02" method="post">
    <input type="submit">
</form>
<br/>
<a href="/haha/handle03">handle03测试params的属性</a>
<br/>
<a href="/haha/handle04">handle04测试headers的属性</a>
<br/>
<hr/>
<h1>测试ResquestMapping-Ant风格URL</h1>
<a href="/ant01" >ant01精确请求地址</a>
<br/>
<a href="/user/admin" >测试PathVairable</a>
</body>
</html>
