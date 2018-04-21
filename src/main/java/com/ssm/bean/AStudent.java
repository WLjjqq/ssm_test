package com.ssm.bean;

public class AStudent {
    private Integer sId;
    private String sName;
    private Integer sAge;
    private String sSex;

    public AStudent() {
    }

    public AStudent(Integer sId, String sName, Integer sAge, String sSex) {
        this.sId = sId;
        this.sName = sName;
        this.sAge = sAge;
        this.sSex = sSex;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    @Override
    public String toString() {
        return "A_Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", sSex='" + sSex + '\'' +
                '}';
    }
}
