# Mybatis

学习路径

- 第一天：

        Mybatis入门
        Mybatis的概述
        Mybatis的环境搭建Mybatis入门案例
- 第二天：

        自定义Mybatis框架（主要的目的是为了让大家了解 Mybatis中执行细节）
        mybatis基本使用
        mybatis的单表crud操作
        mybatis的参数和返回值
        Mybatis的dao编写
        Mybatis配置的细节
            几个标签的使用
- 第三天：

        Mybatis的深入和多表
        Mybatis的连接池
        Mybatis的事务控制及设计的方法
        Mybatis的多表查询
            一对多（多对一）
            多对多
- 第四天：

        mybatis的缓存和注解开发
        mybatis中的加载时机（查询的时机）
        mybatis中的一级缓存和二级缓存
        Mybatis的注解开发
            单表CRUD
            多表查询

---

# 第一天

- 框架：他是开发中的一套解决方案，不同的框架解决的是不同的问题。
- 好处：框架封装了很多的细节，使开发者可以使用极简的方式实现功能，大大提高开发效率。
- 三层架构：
  
  表现层：展示数据

  业务层：处理业务需求

  持久层：和数据库交互

  ![](pic\1.png)

- 持久层技术解决方案
  
  JDBC：Connection、Preparedstatement、Resultset

  Spring的 JdbcTemplate Spring中对jdbc的简单封装

  Apache的 DBUtils：它和 Spring的JabcTemplate很像，也是对Jdbc的简单封装

以上都不是框架：JDBC是规范。Spring和Apache是工具类。

- Mybatis概述
  
  mybatis是一个持久层框架，Java编写。封装了JDBC操作的细节，开发者只需关注sql本身，无需关注注册驱动，创建链接等。
  
  他使用了ORM(Object relation Mapping)思想：

    将数据库表和实体类及实体类的属性对应起来，实现操作实体类实现操作数据库表。

    user User

    id userId

    user_name userName

    我们需要：实体类中的属性和数据库表的字段名保持一致。

    user User

    id Id

    user_name user_name
- Mybatis 入门