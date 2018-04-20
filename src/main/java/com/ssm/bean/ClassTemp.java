package com.ssm.bean;

public class ClassTemp {
	private int classid;
	private String classname;
	private Student students;

public ClassTemp() {
}

public ClassTemp(int classid, String classname, Student students) {
	this.classid = classid;
	this.classname = classname;
	this.students = students;
}

public int getClassid() {
	return classid;
}

public void setClassid(int classid) {
	this.classid = classid;
}

public String getClassname() {
	return classname;
}

public void setClassname(String classname) {
	this.classname = classname;
}

public Student getStudents() {
	return students;
}

public void setStudents(Student students) {
	this.students = students;
}

@Override
public String toString() {
	return "ClassTemp{" +
			"classid=" + classid +
			", classname='" + classname + '\'' +
			", students=" + students +
			'}';
}
}
