package com.guigu.service;


import com.guigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     * j结账：传入哪个用户买了那本书，然后结账
     *
     * @param username
     * @param isbn
     */
    @Transactional
    public void check(String username, String isbn) {
        //1.减库存
        bookDao.updateStock(isbn);
        int price = bookDao.getprice(isbn);
        //2.钱包消费，减去存款
        bookDao.updateBalance(username, price);
    }
}
