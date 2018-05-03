package com.ssm.enums;

public enum ComputerState implements BaseCodeEnum{
    OPEN(10,"开启"),         //开启
    CLOSE(11,"关闭"),         //关闭
    OFF_LINE(12,"离线"),     //离线
    FAULT(200,"故障"),     //故障
    UNKNOWN(255,"未知");     //未知

    private int code;
    private String name;

    ComputerState(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
