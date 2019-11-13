# Tomcat服务器介绍和使用：

服务器的概念和作用：

**问题：**

学习了jva编程之后，java代码的一个很重要的作用就是进行数据的处理，但是目前来说我们运行编写的代码，只有一次性，也就是运行完毕后，如果需要再次运行则需要再次手动启动代码的执行。但是我们无法提前用户会何时发送请求，也就无法决定我们编写的java代码应该什么时候启动运行。而且手动运行也变得不现实。

**解决：**

那么根据java的网络编内容，我们是不是可以使用代码编写一个容器（对象）呢？，该容器可以根据用户的请求来启动并运行我们编写的数据逻辑代码。
答案是可以的。

**实现：**

*服务器解释*：所谓服务器其实就是代码编写的一个可以根据用户请求实时的调用执行对应的逻辑代码的一个$\color{red}{容器}$。在普通用户看来就是一个安装程序。我们只需要将服务器在操作系统上进行安装，并将我们事先编写好的逻辑处理代码根据规则放到服务器的指定位置，启动服务器，那么服务器就自动的会根据接收到请求调用并执行对象的逻辑代码进行处理。

## Tomcat

目录结构介绍：
- \bin存放启动和关闭Tomcat的可执行文件
- \conf存放Tomcat的配置文件
- \lib存放库文件
- \logs存放日志文件temp存放临时文件
- \webapps存放web应用
- \work存放JSP转换后的Servlet文件

*校验安装*:打开bin目录，然后双击执行startup.bat文件，打开浏览器在地址栏中输入localhost：8080/如果出现tomcat广告页安装成功

## Servlet介绍：

问题：服务器在接收到浏览器的请求后，会自动调用对应的逻辑代码进行请求处理。但是逻辑代码是由程序员编写并放到服务器中，那么服务器怎么知道该怎么调用并调用哪个类和哪个方法来进行请求处理。

解决：程序员在编写代码的时候如果能够按照服务器能够识别的规则进行编写，浏览器按照指定的规则进行发送请求，那么服务器就可以调用并执行响应的逻辑代码进行请求处理了。

实现：Servlet技术

概念:
狭义的SerMlet是指Java语言实现的一个接口，广义的Servlet是指任何实现了这个Servlet接口的类，一般情况下，人们将Servlet理解为后者。Serviet运行于支持Java的应用服务器中。从原理上讲，Servlet可以响应任何类型的请求，但绝大多数情况下Servlet只用来扩展基于HTTP协议的Web服务器。

特点：运行在支持java的应用服务器上。

**Servlet的实现遵循了服务器能够识别的规则**，也就是服务器会自动的根据请求调用对应的servlet进行请求处理。
简单方便，可移植性强

使用：

- 创建普通的java类并继承HttpServet
- 重写service方法（此时tomcat才能认识）
- 在service方法中书写逻辑代码
- 再WEB-INF的web.xml配置servlet
  
运行流程：
url:http://locahost:10000/project/my2
组成：

服务器地址：端口号/虚拟项目名 *（idea中会把自定义的编译好的文件发送到webapps）*/servlet别名
*(端口号之后的部分为uri)*

浏览器发送请求到服务器，服务器根据请求URL地址中的URI信息在webapps目录下找到对应的项目文件夹，然后在web.xml中检索对应的servlet，找到后调用并执行Servlet。

## Servlet3.0  @WebServlet注解

Servlet3.0以后，可以不用再web.xml里面配置servlet，只需要加上@WebServlet注解就可以修改该servlet的属性。

属性名|类型|描述
-|-|-
$\color{red}{name}$|String|指定Servlet 的 name 属性，等价于 \<servlet-name>。如果没有显式指定，则该 Servlet 的取值即为类的全限定名。
$\color{red}{value}$|String[]|该属性等价于 urlPatterns 属性。两个属性不能同时使用。
$\color{red}{urlPattern}$|String[]|指定一组 Servlet 的 URL 匹配模式。等价于\<url-pattern>标签。
loadOnStartup|int|指定 Servlet 的加载顺序，等价于 \<load-on-startup>标签。
initParams|WebInitParam[]|指定一组 Servlet 初始化参数，等价于\<init-param>标签。
asyncSuppoeted|boolean|声明 Servlet 是否支持异步操作模式，等价于\<async-supported> 标签。
description|String|该 Servlet 的描述信息，等价于 \<description>标签。
displayName|String|该 Servlet 的显示名，通常配合工具使用，等价于 \<display-name>标签。

- Servlet 生命周期

  1.从第一次调用到服务器关闭
  
  2.若servlet配置了load-on-startup，则生命周期为从服务器启动到服务器关闭

    注意：
  
    init方法是对servlet进行初始化的一个方法，会在servlet第一次加载如内存时执行

desytroy方法是服务器关闭时执行

- Service和doGet和doPost方法的区别

    Service方法：不管是get方式还是post方式的请求，如果Servlet类中有service方法，则优先调用Service方法。

    doGet方法：在没有service方法的情况下如果是get方式的请求所调用的处理请求的方法

    doPost方法：在没有service方法的情况下如果是post方式的请求所调用的处理请求的方法

## request对象

- 问题

    浏览器发起请求到服务器，会遵循HTTP协议将请求数据发送给服务器。那么服务器接受到请求的数据改怎么存储呢？不但要存，而且要保证完成性。
- 解决

    使用对象进行存储，服务器每接受一个请求，就创建一个对象专门的存储此次请求的请求数据。
- 实现

    request对象
- 解释

    服务器接收到浏览器的请求后，会创建一个 Request对象，对象中存储了此次请求相关的请求数据。服务器在调用 Servlet时会将创建的Request对象作为实参传递给 Servlet的方法，比如：service方法。
- 使用：
    
    获取请求头数据
    获取请求行数据
    获取用户数据