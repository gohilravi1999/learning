package com.learning.shared.util;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.shared.bean.ResponseBean;

@Component
public class JsonUtil {

	public static <T> ResponseBean<T> createResponseBean(int statusCode, String message, T responseData){
		ResponseBean<T> responseBean = new ResponseBean<T>();
		responseBean.setStatusCode(statusCode);
		responseBean.setMessage(message);
		responseBean.setResponseData(responseData);
		return responseBean;
	}
	
	public static <T> T createRequestBean(String requestBody) throws Exception{
		TypeReference<T> token = new TypeReference<T>() {};
		ObjectMapper mapper = new ObjectMapper();
		T requestBean = (T) mapper.readValue(requestBody.getBytes(), token);        
		return requestBean;
	}
}
