package Server_study02;

import Server_study01.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 熟悉Sax解析流程
 */
public class XmlTest03 {
    public static void main(String[] args) throws Exception {
        //1.获取获取工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2/从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器

        //4.加载文档Document注册处理器
        WebHandler webHandler = new WebHandler();
        //5。解析
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "Server_study02/web.xml"),webHandler);//注意文件路径。从源目录开始写
        //6.获取数据
        WebContext context = new WebContext(webHandler.getEntitys(),webHandler.getMappings());
        //假设输入了/login
        String classNmae = context.getClz("/reg");
        Class clz = Class.forName(classNmae);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        servlet.service();

    }
    }

class WebHandler extends DefaultHandler{
    private List<Entity> entitys = new ArrayList<>();
    private List<Mapping> mappings = new ArrayList<>();

    private Entity entity;
    private Mapping mapping;
    private  String tag;//存储操作的标签
    private boolean isMapping = false;

    public List<Entity> getEntitys() {
        return entitys;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (null!=qName) {
            tag = qName;//存储标签,qName表示标签名或元素名
            if (tag.equals("servlet")) {
                entity = new Entity();
                isMapping = false;
            }else if (tag.equals("servlet-mapping")){
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (null!=tag) {
            if (isMapping) {//操作server-mapping
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                }else if (tag.equals("url-pattern")){
                    mapping.addPattern(contents);
                }
            }else {//操作servlet
                if (tag.equals("servlet-name")) {
                    entity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(contents);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (null!= qName) {
            if (qName.equals("servelt")) {
                entitys.add(entity);
            }else if (qName.equals("servlet-mapping")){
                mappings.add(mapping);
            }
        }
        tag = null;//tag丢弃
    }


}