package com.guigu.spring;

public class AirPlane {
    private String fdj;
    private String yc;
    private Integer psersonNum;
    private String jzName;
    private String fjsName;

    public AirPlane() {
    }

    public AirPlane(String fdj, String yc, Integer psersonNum, String jzName, String fjsName) {
        this.fdj = fdj;
        this.yc = yc;
        this.psersonNum = psersonNum;
        this.jzName = jzName;
        this.fjsName = fjsName;
    }

    public String getFdj() {
        return fdj;
    }

    public void setFdj(String fdj) {
        this.fdj = fdj;
    }

    public String getYc() {
        return yc;
    }

    public void setYc(String yc) {
        this.yc = yc;
    }

    public Integer getPsersonNum() {
        return psersonNum;
    }

    public void setPsersonNum(Integer psersonNum) {
        this.psersonNum = psersonNum;
    }

    public String getJzName() {
        return jzName;
    }

    public void setJzName(String jzName) {
        this.jzName = jzName;
    }

    public String getFjsName() {
        return fjsName;
    }

    public void setFjsName(String fjsName) {
        this.fjsName = fjsName;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "fdj='" + fdj + '\'' +
                ", yc='" + yc + '\'' +
                ", psersonNum=" + psersonNum +
                ", jzName='" + jzName + '\'' +
                ", fjsName='" + fjsName + '\'' +
                '}';
    }
}
