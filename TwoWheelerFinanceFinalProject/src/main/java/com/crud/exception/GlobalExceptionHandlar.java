package com.crud.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandlar {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiError> cutomerNotFoundExceptionHandler(CustomerNotFoundException e,HttpServletRequest request){
		log.info("Customer Not found exception handler methods");
		ApiError error=new ApiError(HttpStatus.NOT_FOUND.value(),e.getMessage(),new Date(),request.getRequestURI());
			
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
		
		//eg.  http://localhost:9099/customer/getCustById/122     get
		//{ "errorCode": 404,
		//	"errorMsg": "customer Id not found in catch block",
		//    "date": "2022-01-28T14:55:08.285+00:00",
		//    "path": "/customer/getCustById/122"	}
	}
	
}
