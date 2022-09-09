package com.learning.student.controller;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.shared.bean.ResponseBean;
import com.learning.shared.constant.StatusCode;
import com.learning.shared.util.JsonUtil;
import com.learning.shared.validation.ValidationService;
import com.learning.student.bean.StudentDTO;
import com.learning.student.service.StudentService;
import com.learning.student.url.StudentUrl;

@RestController
@RequestMapping(StudentUrl.STUDENT)
public class StudentController {
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired 
	private MessageSource messageSource;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ValidationService validationService;

	@PostMapping
	public ResponseBean<Map<String, String>> addStudent(@RequestBody String requestBody,
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) throws Exception {
		ResponseBean<Map<String, String>> responseBean = new ResponseBean<Map<String, String>>();
		StudentDTO studentDto = mapper.convertValue(JsonUtil.createRequestBean(requestBody), StudentDTO.class);		
		if(validationService.validateBean(studentDto)){
			Map<String, String> studentMap = studentService.addStudent(studentDto);
			responseBean = JsonUtil.createResponseBean(StatusCode.STATUS_OK,
					messageSource.getMessage("saved.successfully.message", null, locale), studentMap);
		}
		return responseBean;
	}

}
