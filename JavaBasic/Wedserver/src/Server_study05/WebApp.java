package Server_study05;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.desktop.SystemSleepEvent;
import java.lang.reflect.InvocationTargetException;

public class WebApp {
    private static WebContext webContext;

    static {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2/从解析工厂获取解析器
            SAXParser parse = factory.newSAXParser();
            //3.编写处理器

            //4.加载文档Document注册处理器
            WebHandler webHandler = new WebHandler();
            //5。解析
            parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                    "Server_study05/web.xml"), webHandler);//注意文件路径。从源目录开始写
            //6.获取数据
            webContext = new WebContext(webHandler.getEntitys(), webHandler.getMappings());

        } catch (Exception e) {
            System.out.println("解析配置文件错误");
        }
    }

    /**
     * 通过url获取配置文件对应的Servlet
     * @param uri
     * @return
     * @throws Exception
     */
    public static Servlet gtServletFromURL(String uri) throws Exception {
        //假设输入了/login
        int place = uri.indexOf("?");
        uri = uri.substring(0,place);
        String classNmae = webContext.getClz("/" + uri);
        System.out.println(classNmae+"--->"+uri+"---->");
        Class clz = Class.forName(classNmae);
        Servlet servlet = (Servlet) clz.getConstructor().newInstance();
        return servlet;
    }

}
