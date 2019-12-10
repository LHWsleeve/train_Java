package com.guigu.service;

import com.guigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void save(){
        System.out.println("bookService正在调用dao帮你保存图书....");
        bookDao.saveBook();
    }
}
