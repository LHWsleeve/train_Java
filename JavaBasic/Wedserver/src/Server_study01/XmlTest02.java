package Server_study01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 熟悉Sax解析流程
 */
public class XmlTest02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1.获取获取工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2/从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器

        //4.加载文档Document注册处理器
        PersonHandler handler = new PersonHandler();
        //5。解析
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(
                "Server_study01/p.xml"),handler);//注意文件路径。从源目录开始写
        //6.获取数据
        List<Person> persons = handler.getPersons();
        for (Person p:persons){
            System.out.println(p.getName()+"--->"+p.getAge());
        }
    }
}

class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private  String tag;//存储操作的标签
    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<>();

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (null!=qName) {
            tag = qName;//存储标签,qName表示标签名或元素名
            if (tag.equals("person")) {
                person = new Person();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (null!=tag) {
            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                if (contents.length() > 0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (null!= qName) {
            if (qName.equals("person")) {
                persons.add(person);
            }
        }
        tag = null;//tag丢弃
    }

    @Override
    public void endDocument() throws SAXException {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}