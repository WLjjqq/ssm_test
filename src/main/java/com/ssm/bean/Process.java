package com.ssm.bean;

import com.ssm.enums.ComputerState;

public class Process {
    private Integer id;
    private String name;
    private ComputerState status;
    public Process() {
    }

    public Process(Integer id, String name, ComputerState status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComputerState getStatus() {
        return status;
    }

    public void setStatus(ComputerState status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
