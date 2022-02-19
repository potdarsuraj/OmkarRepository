package com.crud.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

	private int errorCode;
	private String errorMsg;
	private Date date;
	private String path;
	
}
