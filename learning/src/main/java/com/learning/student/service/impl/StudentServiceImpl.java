package com.learning.student.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.student.bean.Student;
import com.learning.student.bean.StudentDTO;
import com.learning.student.dao.StudentDao;
import com.learning.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao studentDao;

	public Map<String, String> addStudent(StudentDTO studentDto) throws IllegalAccessException, InvocationTargetException {
		Student student = new Student();
		BeanUtils.copyProperties(student, studentDto);
		student.setId(UUID.randomUUID().toString());
		studentDao.save(student);
		Map<String, String> studentMap = new HashMap<String, String>();
		studentMap.put("Name:", student.getName());
		studentMap.put("Email:", student.getEmail());
		studentMap.put("Address:", student.getAddress());
		return studentMap;
	}

}
