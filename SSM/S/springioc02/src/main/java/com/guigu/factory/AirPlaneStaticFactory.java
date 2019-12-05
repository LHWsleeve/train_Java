package com.guigu.factory;

import com.guigu.spring.AirPlane;

/**
 * 静态工厂：有static不需要new
 */
public class AirPlaneStaticFactory {
    public static AirPlane getAirPlane(String jzName){
        System.out.println("静态工厂创建完成");
       AirPlane airPlane = new AirPlane();
       airPlane.setFdj("发动机A");
       airPlane.setFjsName("副驾驶刘大");
       airPlane.setJzName(jzName);
        airPlane.setPsersonNum(100);
        airPlane.setYc("机翼100m");
        return airPlane;
    }
}
