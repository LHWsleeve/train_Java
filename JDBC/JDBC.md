什么是JDBC？
---
1. JDBC（Java Database Connection）为java开发者使用数据库提供了**统一的编程接口**，它由一组java类和接口组成。是java程序与数据库系统通信的标准API。JDBCAPI使得开发人员可以使用纯java的方式来连接数据库，并执行操作。
2. sun公司由于不知道各个主流商用数据库的程序代码，因此无法自己写代码连接各个数据库，因此，sun公司决定，自己提供一套api，凡是数据库想与Java进行连接的，数据库厂商自己必须实现JDBC这套接口。而数据库厂商的JDBC实现，我们就叫他此数据库的数据库驱动。
## 访问数据库流程
加载JDBC驱动程序-->建立与数据库的链接-->发送SQL查询-->得到查询结果
###JDBC常用接口
·Driver接口

-Driver接口由数据库厂家提供，对于java开发者而言，只需要使用Driver接口就可以了。

-在编程中要连接数据库，必须先装载特定厂商的数据库驱动程序。不同的数据库有不同的装载方法。

-驱动：就是各个数据库厂商实现的Sun公司提出的JDBC接口。即对Connection等接口的实现类的jar文件

-装载MySql区动·Class.forName（"com.mysqljdbc.Driver"）；

-装载Oracle驱动·Class，forName（"oracleidbc.driver.OracleDriver"）；