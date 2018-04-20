package com.ssm.service;


import com.ssm.bean.StudentTemp;

import com.ssm.bean.Class;
public interface StudentService {
	//根据id查询
	StudentTemp selectStudent(Integer id);
	//保存
	int insertStudentAndClass(StudentTemp studentTemp);

//修改
int updateStudent(StudentTemp studentTemp);

//删除
int deleteStudent(Integer id);
}
