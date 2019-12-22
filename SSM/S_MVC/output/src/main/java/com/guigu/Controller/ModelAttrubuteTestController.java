package com.guigu.Controller;


import com.guigu.book.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 测试ModelAttrubute注解：
 * 使用场景：书城的图书修改为例；
 * 1.页面端：显示要修改的图书信息，图书的所有字段都子啊
 * 2.servlet收到请求，调用dao
 * 3.实际场景：并不是全字段修改：只会修改部分。已修改用户信息为例：可能只改密码等
 *      所以实际场景中，1.不修改的字段不在页面进行展示。
 *                      2.为了简单Controller直接在参数位置来写Book对象
 *                      3.SpringMVC为我们自动封装book，所以没有带的值为Null
 *                      4.如果接下来调用了一个全字段更新的dao操作；会将其他的字段可能变为null
 * 4.如何保证全字段更新时，只更新页面携带的数据
 *   1.
 *   2.Book对象是如何封装的
 *      1.springmvc创建一个book对象，每个属性都有默认值，没赋值就是null
 *          //如果让MVC不创建对象，直接从数据库中创建一个id=100的book
 *           //此时book已经实例化
 *     2。将对象对应的属性一一设置
 *           // 使用从数据库去除的book对象，给他里面设置值（页面带的字段，更改。没带的字段，保持原值）
 *      3.所以调用全字段更新就有问题
 *          //此时调用全字段更新，就没事了
 *
 *5. 告诉SpringMVC不要new 对象，用我们已经保存的对象
 *      在参数类型前加上@ModelAttribute("xxx"),xxx是保存时的名字
 *
 *
 */
@Controller
public class ModelAttrubuteTestController {

    @RequestMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book){
        System.out.println("页面要提交过来的图书信息："+book);

        return "success";
    }

    /**
     * SpringMVC要封装请求参数的Book对象，不应该是自己new的，而是从数据库中拿到的准备好的对象
     * @ModelAttribute：可以标注，
     * 参数：
     * 方法位置：这个方法会在目标方法前运行；
     *          1.我们可以在提前的方法中查出数据库中的信息
     *          2.保存数据库找出的信息，方便下一个方法使用
     */

@ModelAttribute
    public void modelA(Map<String,Object> map){
    Book book = new Book(100,"西游记","吴承恩", 100, 10, 99.);
    map.put("book",book);
    System.out.println("ModelAttribute结束");
    System.out.println("ModelAttribute的map类型："+map.getClass());

}



}


