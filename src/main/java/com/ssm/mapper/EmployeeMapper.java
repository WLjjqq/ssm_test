package com.ssm.mapper;

import java.util.List;

import com.ssm.bean.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper{
	 List<Employee> selectEmployee();
	 int insertEmployee(Employee employee);

}
