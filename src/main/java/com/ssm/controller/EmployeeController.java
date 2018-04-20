package com.ssm.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bean.Employee;
import com.ssm.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/emps")
	@ResponseBody
	public  Msg test(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
		PageHelper.startPage(pn,2);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps=employeeService.getEmps();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(emps, 2);
		return Msg.success().add("pageInfo", page);
	}
			/*	新增：/order POST
			　　修改：/order/id PUT
			　　获取：/order/id GET
			　　删除：/order/id DELETE*/
	@RequestMapping(value = "/saveEmp",method = RequestMethod.GET)
	@ResponseBody
	public int test2(Employee employee){
		int a = employeeService.insertEmp(employee);
		return a;
	}

}
