package com.ssm.bean;

public class Student {
	private int studentid;
	private String studentname;

	public Student() {
	}

public Student(int studentid, String studentname) {
	this.studentid = studentid;
	this.studentname = studentname;
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

@Override
public String toString() {
	return "Student{" +
			"studentid=" + studentid +
			", studentname='" + studentname + '\'' +
			'}';
}
}
