package com.ssm.bean;

/*
学生
 */
public class StudentTemp {
	private int studentid;
	private String studentname;
	private Class tempClass;

public StudentTemp() {
}

public StudentTemp(int studentid, String studentname) {
	this.studentid = studentid;
	this.studentname = studentname;
}

public StudentTemp(int studentid, String studentname, Class tempClass) {
	this.studentid = studentid;
	this.studentname = studentname;
	this.tempClass = tempClass;
}

public int getStudentid() {
	return studentid;
}

public void setStudentid(int studentid) {
	this.studentid = studentid;
}

public String getStudentname() {
	return studentname;
}

public void setStudentname(String studentname) {
	this.studentname = studentname;
}

public Class getTempClass() {
	return tempClass;
}

public void setTempClass(Class tempClass) {
	this.tempClass = tempClass;
}

@Override
public String toString() {
	return "StudentTemp{" +
			"studentid=" + studentid +
			", studentname='" + studentname + '\'' +
			", tempClass=" + tempClass +
			'}';
}
}
