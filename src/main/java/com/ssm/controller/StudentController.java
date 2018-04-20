package com.ssm.controller;

import com.ssm.bean.StudentTemp;
import com.ssm.service.StudentService;
import com.ssm.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	//查询学生
	@RequestMapping(value = "/getStudent/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Msg testQueryStudent(@PathVariable("id") Integer id){
		StudentTemp studentTemp=studentService.selectStudent(id);
		return Msg.success().add("studentTemp",studentTemp);
	}
	//保存学生
//请求的路径
	@RequestMapping(value = "/saveStudent",method = RequestMethod.POST)
	@ResponseBody
	public Msg testSaveStudent(StudentTemp studentTemp){
		int b=studentService.insertStudentAndClass(studentTemp);
		return Msg.success().add("success",b);
	}
	//删除学生

	@RequestMapping(value = "/deleteStudent/{id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Msg testDeleteStudent(@PathVariable("id") Integer id){
		int a=studentService.deleteStudent(id);
		return Msg.success().add("success",a);
	}
	//修改学生信息
	@RequestMapping(value = "/updateStudent/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public Msg testUpdateStudent(@PathVariable("id") Integer id){
		int c=studentService.deleteStudent(id);
		return Msg.success().add("success",c);
	}
}
