package com.ssm.bean;

public class ACourse {
    private Integer cId;
    private String cName;
    private Integer tId;

    public ACourse() {
    }

    public ACourse(Integer cId, String cName, Integer tId) {
        this.cId = cId;
        this.cName = cName;
        this.tId = tId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "A_Course{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", tId=" + tId +
                '}';
    }
}
