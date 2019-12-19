
<%@ page contentType="text/html;charset=UTF-8" language="java"
         %>

<html>
<body>

<%--发起图书的增删改查请求：使用REST风格的URL地址：
请求url   请求方式  表示含义
/book/1   ：GET--查询1号图书
/book/1   ：PUT--更新1号图书
/book/1   ：DELETE-删除1号图书
/book   ：POST---添加图书

在页面如何发起put,delect请求
1）SpringMVC中有一个Fliter：它可以把普通的请求转化为规定形式的请求-->w
    <filter>
      <filter-name>HiddenHttpMethodFilter</filter-name>
      <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
      <filter-name>HiddenHttpMethodFilter</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>
 2).如何发其他形式请求？：
        按照以下要求：1.创建一个post类型的表单2.表单中携带一个_method的参数 3.这个_method的值就是DELET或者PUT
--%>
<a href="/book/1">查询图书</a><br/>

<form action="/book" method="post">
    <input type="submit" value="添加1号"/>
</form><br/>

<form action="/book/1" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除1号图书">
</form>
<br/>

<form action="/book/1" method="post">
    <input name="_method" value="put">
    <input type="submit" value="更新1号图书">
</form>
<br/>
</body>
</html>
