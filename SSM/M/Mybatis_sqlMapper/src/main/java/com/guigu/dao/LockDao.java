package com.guigu.dao;

import com.guigu.bean.Lock;

public interface LockDao {
    //查锁，顺便查出对应钥匙
    public Lock getLockById(Integer id);
}
