package com.guigu.bean;

import org.apache.ibatis.annotations.Select;

public class Key {
    private Integer id;
    private String keyName;
    private Lock lock;//封装当前要是开那个锁

    public Key() {
    }

    public Key(Integer id, String keyName, Lock lock) {
        this.id = id;
        this.keyName = keyName;
        this.lock = lock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "Key[" +
                "id=" + id +
                ", keyName='" + keyName + '\'' +
                ", lock=" + lock +
                ']';
    }
}
