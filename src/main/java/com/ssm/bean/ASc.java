package com.ssm.bean;

public class ASc {
    private Integer sId;
    private Integer cId;
    private Integer sCore;

    public ASc() {
    }

    public ASc(Integer sId, Integer cId, Integer sCore) {
        this.sId = sId;
        this.cId = cId;
        this.sCore = sCore;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getsCore() {
        return sCore;
    }

    public void setsCore(Integer sCore) {
        this.sCore = sCore;
    }

    @Override
    public String toString() {
        return "A_Sc{" +
                "sId=" + sId +
                ", cId=" + cId +
                ", sCore=" + sCore +
                '}';
    }
}
