<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Sleeve
  Date: 2020/1/11
  Time: 11:10
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
<%=new Date()%>
<a href="/getallajax">ajax获取所有员工给</a>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function () {
        //1.发送AJAX获取所有员工
        $.ajax({
             url:"${cpt}/getallajax",
             type:"GET",
            success:function (data) {
                 // console.log(data);
            $.each(data,function () {
                var empInfo = this.lastName+"-->"+this.email+"--->"+this.gender;
                $("div").append(empInfo);

            })
             }
         });

        return false;

    })
</script>
</body>
</html>
