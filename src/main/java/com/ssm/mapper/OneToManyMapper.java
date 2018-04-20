package com.ssm.mapper;


import com.ssm.bean.*;

public interface OneToManyMapper {
	 StudentTemp getStudentAndClass(Integer id);
	 studentclass getStudentAndClassView(Integer id);
	 ClassTemp getClassStudents(Integer id);
	 //插入学生和班级(mybati不支持级联保存)
	int saveStudentAndClass(StudentTemp studentTemp);
	//修改
	int updateStudent(StudentTemp studentTemp);

//删除
int deleteStudent(Integer id);
}
