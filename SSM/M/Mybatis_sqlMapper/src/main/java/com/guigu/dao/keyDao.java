package com.guigu.dao;

import com.guigu.bean.Key;

public interface keyDao {
    /**
     * 将钥匙和锁一起查出
     * @return
     */
    public Key getKeyById(Integer id);

    //只根据id查钥匙
    public Key getKeyByIdSim(Integer id);

}
