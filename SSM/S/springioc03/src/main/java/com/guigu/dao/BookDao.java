package com.guigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * 1.id是类名首字母小写。注意仅仅是首字母！
 * 2.直接在注解内写新名字，会将默认名覆盖。
 *上下分配的都是同一块空间，并且默认单实例
 */
@Repository
//@Scope(value="prototype")
public class BookDao {
    
    public void saveBook(){
        System.out.println("图书已经保存了");
    }

}
