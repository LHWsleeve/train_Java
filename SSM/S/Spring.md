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

spring的配置文件中，集合了Spring的IOC容器管理的所有组件(注册清单)；

创建一个SpringConfig.xml文件

  ***一定记住IDEA必须放在resources中才会编译xml***

## 总结
ioc是一个容器，帮我们管理所有的组件

    1、依赖注入回 Autowired自动赋值

    2、某个组件要使用 Spring提供的更多（I0C、AOP）必须加入到容器中

体会

    1、容器启动。创建所有单实例bean

    2、autowired自动装配的时侯，是从容器中找这些符合要求的bean

    3、ioc.getBean（"bookserylet"）：也是从容器中找到这个bean

    4、容器中包括了所有的bean

    5、调试 spring的源码，容器到底是什么？其实就是一个map

    6.这个map中保存所有创建好的bean，并提供外界获取功能

    7.探索，单实例的bean都保存到哪个map中了。【源码-扩展】


# AOP（Aspect Oriented Programming）
 AOP：(Aspect Oriented Programming)面向切面编程

 OOP：(Object Oriented Programming)面向对象编程

 面向切面编程：基于OOP的新的编程思想；程序运行期间将某段代码动态的切入到指定方法的指定位置进行运行的这种编程方式。

 场景：计算器运行计算方法的时候进行日志记录

 加日志记录：
        
    1.直接编写在方法内部；不推荐，修改维护麻烦。
        日志记录：系统的辅助功能
        业务逻辑：核心功能
    这种方法会导致上俩耦合。
    即便是创建日志工具类，进行日志添加。还是会将日志类的逻辑写入业务逻辑中，导致耦合。
    我们之后 所做的一切就是为了解耦

    2.我们希望的是：
    业务逻辑是核心功能，日志模块在核心功能运行期间，自己动态加上。（动态代理）
可以使用动态代理来讲日志代码动态的在目标方法执行前后进行执行

动态代理得问题：

<font color="red"> jdk默认的动态代理，如果目标对象没有实现任何接口，那么无法为他创建代理对象。</font>

![](pic\2.png)

Spring动态代理：Spring实现了AOP功能；底层就是动态代理。

1).可以利用Spring一句代码都不写来创建动态代理。
  
  实现简单，而且不强制要求目标对象必须实现接口。

 <font color="red">将某段代码（日志）</font><font color="green">动态的切入（不把日志代码写死在业务逻辑方法中）到</font><font color="blue">指定方法（加减乘除）的指定位置(方法的开始.结束等)</font>。这种编程方式就是面向切面编程。

 ---
 AOP专业术语：![](pic\3.png)
 横切关注点：每一个需要执行的方法的都关注”方法开始“的位置，被称为横切关注点。（图画的有点问题，应该是add，sub，mul，div每个方法对应一个横切关注点）

 通知方法：我们在日志工具类中写的方法。

<font color="red">此时这个日志工具类包就是切面类，内部方法为通知方法</font>

---
AOP使用步骤;
1) 导包Maven
2) 写配置：
    
    a.将目标类和前面类(封装了通知方法(在目标方法执行前后执行 的方法))加入到ioc容器中

    b. 还应该告诉Spring到底那个是切面类(使用注解@Aspect)
    
    c. 告诉Spring，切面类里面的每一个方法，都在何时何地运行
    ![](pic\4.png)
    还有第五个注解：@Around：环绕
    
    d. 开启基于注解的aop模式
3) 测试
