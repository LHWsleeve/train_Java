package com.guigu.bean;

import java.util.List;

public class Lock {
    private Integer id;
    private String lockName;
    //查询锁，同时查出所有钥匙
    private List<Key> keys;
    /**1-1关联：一个key开一把lock
       1-n关联：一个lock可能有多个钥匙
       n-1关联：
       n-n关联：
     不管什么情况：外键放在那个表？
     一对多，外键一定放在多的一端；
     多对多：使用中间表，存储对应关系。

    **/

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public Lock() {
    }

    public Lock(Integer id, String lockName) {
        this.id = id;
        this.lockName = lockName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    @Override
    public String toString() {
        return "Lock[" +
                "id=" + id +
                ", lockName='" + lockName + '\'' +
                ", keys=" + keys +
                ']';
    }
}
