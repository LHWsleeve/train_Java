package com.guigu.service;

import com.guigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookEXT extends BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public void save() {
        System.out.println("EXT被调用");
    }
}
