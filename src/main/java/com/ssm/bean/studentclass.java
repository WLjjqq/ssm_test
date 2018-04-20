package com.ssm.bean;

public class studentclass {
	private int s_id;
	private String s_name;
	private int class_id;
	private String class_name;

public studentclass() {
}

public studentclass(int s_id, String s_name, int class_id, String class_name) {
	this.s_id = s_id;
	this.s_name = s_name;
	this.class_id = class_id;
	this.class_name = class_name;
}

public int getS_id() {
	return s_id;
}

public void setS_id(int s_id) {
	this.s_id = s_id;
}

public String getS_name() {
	return s_name;
}

public void setS_name(String s_name) {
	this.s_name = s_name;
}

public int getClass_id() {
	return class_id;
}

public void setClass_id(int class_id) {
	this.class_id = class_id;
}

public String getClass_name() {
	return class_name;
}

public void setClass_name(String class_name) {
	this.class_name = class_name;
}

@Override
public String toString() {
	return "studentclass{" +
			"s_id=" + s_id +
			", s_name='" + s_name + '\'' +
			", class_id=" + class_id +
			", class_name='" + class_name + '\'' +
			'}';
}
}
