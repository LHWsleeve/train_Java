package com.guigu.spring.dao;

import com.guigu.spring.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {
    @Override
    public void save() {
        System.out.println("保存图书///");
    }
}
