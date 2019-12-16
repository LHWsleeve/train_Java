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
     *事务的细节：
     * isolation ---Isolation:事物的隔离级别
     * propagation---Propagation：事物的传播行为
     *
     * noRollbackFor---Class[]：那些异常事务可以不回滚
     * noRollbackForClassName--String[]（String全类名）：
     *
     * rollbackFor---Class[]：哪些异常事务需要回滚
     * rollbackForClassName---String[]：
     *
     * 异常分类：
     *         非检查异常==运行时异常（编译器不报错但实际运行有问题的）：
     *         可以不处理。默认都会滚
     *         检查异常==编译时异常（写出来编译器就会报错的）：
     *         要么try要么抛出，必须处理。默认不回滚
     *
     * 事物的回滚：默认发生运行时异常都回滚，编译时异常不会滚（会影响数据库）。
     *
     *          noRollbackFor：让原来默认回滚的异常，不回滚。
     *          但是要知道，在异常之前的代码会执行，之后的不执行。
     *
     *          rollbackFor：原本编译时异常是不会滚，现在回滚
     *

     * readOnly---boolean：调整事务为只读属性
     *            可以进行事务优化；
     *           如果都是查数据， readOnly = true；可以加快查询速度，不用管事务操作
     *           如果在增删改的操作中使用readOnly会报错
     * timeout---int：超时.s为单位，超出指定时常后自动终止并回滚
     *
     * @param username
     * @param isbn
     */
    @Transactional(noRollbackFor = {ArithmeticException.class})
    public void check(String username, String isbn) throws InterruptedException {
        //1.减库存
        bookDao.updateStock(isbn);
//        Thread.sleep(3000);
        int i = 10/0;
        int price = bookDao.getprice(isbn);
        //2.钱包消费，减去存款
        bookDao.updateBalance(username, price);



    }
}
