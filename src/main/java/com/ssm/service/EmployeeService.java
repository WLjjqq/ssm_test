package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.bean.Employee;
import com.ssm.mapper.EmployeeMapper;

@Service
public class EmployeeService {
@Autowired
EmployeeMapper employeeMapper;

public List<Employee> getEmps(){
	return employeeMapper.selectEmployee();
}

public int insertEmp(Employee employee){
	int a=employeeMapper.insertEmployee(employee);
	if(a>0){
		return a;
	}else{
		return -1;
	}

}
}
