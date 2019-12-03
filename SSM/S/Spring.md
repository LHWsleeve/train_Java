# Spring：容器框架

容器框架，可以管理所有的(类)组件；

核心IOC和AOP；
特性：

    [1]非侵入式。基于Spring开发应用中的对象可以不依赖于Spring的Api
    [2]依赖注入：DI--Dependency Injection，反转控制IOC最经典的实现。
    [3]面向切面编程：Aspect Oriented Programming--AOP
    [4]容器：Spring是一个容器，因为它包含并且管理应用对象的生命周期
    [5]组件化：Spring实现了使用简单的组件配置组合成一个复杂的应用在 Spring中可以使用XML和ava注解组合这些对象。
    [6]一站式：在1OC和AOp的基础上可以整合各种企业应用的开源框架和优秀的第三方类库（实际上 Spring自身也提供了表述层的 SpringMVC和持久层的 Spring JDBC）。

![](pic\1.png)
IOC(控制反转):

控制：控制资源的获取方式

    主动式：(自己new资源)
    BookServlet{
        BookServivce bs = new Bookservice();
        AirPlane ap = new AirPlane();//复杂对象对创建时庞大的工程；
    }
    被动式：资源的获取不是我们自己创建，而是交给一个容器来创建。
     BookServlet{
        BookServivce bs
        public void test01(){
            bs.checkout();
        }
     }
**容器**：管理所有的组件(有功能的类)；假设BookServlet受容器管理，BookServlet也受容器管理；容器可以自动的探查出那些组件需要用到另一些组件；容器帮我们创建BookService对象，并把BookService对象赋值过去。

主动的new资源变为被动的接受资源；

**DI**：依赖注入；
容器能知道那个组件运行的时候需要另外一个类；容器通过反射的形式，将容器中准备好的BookService对象注入道BookServlet中；

只要容器管理的组件，都能使用容器提供的功能。

---
HelloWord；
以前自己是new对象，现在所有的对象交给容器创建；***给容器中注册组件***

框架编写流程：

1.导包

使用Maven导入核心薄

2.写配置

spring的配置文件中，集合了Spring

3.测试