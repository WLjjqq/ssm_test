package com.ssm.service.impl;

import com.ssm.bean.StudentTemp;
import com.ssm.mapper.OneToManyMapper;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.bean.Class;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private OneToManyMapper oneToManyMapper;

public StudentTemp selectStudent(Integer id) {
	return	oneToManyMapper.getStudentAndClass(id);

}

public int insertStudentAndClass(StudentTemp studentTemp) {

		int trueOrFalse=oneToManyMapper.saveStudentAndClass(studentTemp);
		if(trueOrFalse > 0){
			return trueOrFalse;
		}else {

			return -1;
		}
}

public int updateStudent(StudentTemp studentTemp) {
	int update_a = oneToManyMapper.updateStudent(studentTemp);
	if (update_a>0){
		return update_a;
	}else{
		return -1;
	}

}

public int deleteStudent(Integer id) {
	int delete_a = oneToManyMapper.deleteStudent(id);
	if(delete_a>0){
		return delete_a;
	}else {
		return -1;
	}

}
}
