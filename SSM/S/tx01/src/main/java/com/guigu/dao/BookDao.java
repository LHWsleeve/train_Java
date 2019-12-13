package com.guigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BookDao {


    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * 1.减余额
     */
    public void updateBalance(String userName,int price){
        String sql = "UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql,price,userName);

    }

    /**
     *按照图书的ISBN查询某本书的价格
     * @param isbn
     * @return
     */
    public int getprice(String isbn){
        String sql = "SELECT price FROM book WHERE isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }
/**
 * 减库存
 */
public void updateStock(String isbn){
    String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?;";
    jdbcTemplate.update(sql,isbn);
}

}
