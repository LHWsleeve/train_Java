package com.guigu.factory;

import com.guigu.spring.AirPlane;

/**
 * 实例工厂，必须先new工厂
 */
public class AirPlaneInstanceFactory {
    public AirPlane getAirPlane(String jzName){
        System.out.println("实例工厂创建完成.....");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("发动机A");
        airPlane.setFjsName("副驾驶刘大");
        airPlane.setJzName(jzName);
        airPlane.setPsersonNum(100);
        airPlane.setYc("机翼100m");
        return airPlane;
    }
}
