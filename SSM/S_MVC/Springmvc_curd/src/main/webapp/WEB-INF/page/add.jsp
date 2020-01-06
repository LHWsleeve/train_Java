<%--
  Created by IntelliJ IDEA.
  User: Sleeve
  Date: 2020/1/5
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加员工</title>
</head>

<body>
<h1>员工添加</h1>
<%--    表单标签,通过springMVC的表单标签可以实现将模型数据中的属性和HTML 表单元素相绑定，以实现表单数据更便编辑和表单值回显
SpringMVC认为，表单数据中的每一项最终都是要回显的
            path指定的是一个属性；属性是从隐含模型(请求域取出的对象中的属性)
            path指定的每一个属性，请求与中**必须**有一个对象有这个属性
                        这个对象就是请求域中的command
            modelAttribute:1.以前表单标签会从请求域中获取一个command对象，把这个对象中的每一个属性对应的显示出来
                            2.可以告诉Springmvc不要去取command的值，我放了一个modelAttribute指定的值
                                取对象时用的key用指定的--%>
<form:form action="" modelAttribute="employee">
<%--    path就是原来html-input的name
         1.当作原生的name项
         2. 自动回显隐含模型中某个对象对应的这个属性的值--%>
    lastName:<form:input path="lastName"/><br/>
    email:<form:input path="email"/><br/>
    gender:
        男：<form:radiobutton path="gender" value="1"/><br/>
        女：<form:radiobutton path="gender" value="0"/><br/>
<%--    items指定要遍历的集合,自动遍历：遍历出的每一个元素是一个department对象
        itemlabel=”属性“：指定遍历出的这个对象的哪个属性作为option标签体的值
        itemValue:指定刚才遍历出的对象，哪个属性作为被提交的value值--%>
    dept:<form:select path="department.id"
                      items="${depts}" itemLabel="departmentName"
                      itemValue="id"></form:select>
    <input type="submit" value="保存"/>
</form:form>


<%--<br action="">--%>
<%--    lastName：<input type="text" name="lastName"/><br/>--%>
<%--    email：<input type="text" name="email"/><br/>--%>
<%--    gender：<br/>--%>
<%--        男：<input type="radio" name="gender" value="1"/><br/>--%>
<%--        女：<input type="radio" name="gender" value="0"/><br/>--%>
<%--    dept:--%>
<%--        <select name="department.id">--%>
<%--            <c:forEach items="${depts}" var="deptItem">--%>
<%--                <option value="${deptItem.id}">${deptItem.departmentName}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
<%--<input type="submit" value="提交"/>--%>
<%--</form>--%>
</body>
</html>
