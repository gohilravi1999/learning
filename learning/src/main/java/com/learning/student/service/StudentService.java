package com.learning.student.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.learning.student.bean.StudentDTO;

public interface StudentService {
 
	public Map<String,String> addStudent(StudentDTO studentDto) throws IllegalAccessException, InvocationTargetException;
}
