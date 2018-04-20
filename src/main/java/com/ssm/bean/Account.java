package com.ssm.bean;

public class Account {

	private Integer id;
	private String name; //账户名
	private Integer points; //积分

public Account() {
}

public Account(Integer id, String name, Integer points) {
	this.id = id;
	this.name = name;
	this.points = points;
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

public Integer getPoints() {
	return points;
}

public void setPoints(Integer points) {
	this.points = points;
}

@Override
public String toString() {
	return "Account{" +
			"id=" + id +
			", name='" + name + '\'' +
			", points=" + points +
			'}';
}
}
