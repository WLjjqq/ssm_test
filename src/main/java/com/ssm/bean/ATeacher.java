package com.ssm.bean;

public class ATeacher {
    private Integer tId;
    private String tName;

    public ATeacher() {
    }

    public ATeacher(Integer tId, String tName) {
        this.tId = tId;
        this.tName = tName;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "A_Teacher{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                '}';
    }
}
