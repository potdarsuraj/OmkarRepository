package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Cibil_check;
import com.crud.service.CibilService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/cibil")  
public class CibilController {
	
	@Autowired
	CibilService cs;
					
	@GetMapping(value = "/getCibilData")	//http://localhost:9027/cibil/getCibilData
	public ResponseEntity<List<Cibil_check>> getCibil()
	{
		log.info("checking method calling using @Slf4j :");
		List<Cibil_check> list=cs.viewCibil();
		if(list.isEmpty())
		{
			//Long b=20/pid; //for controller based exception handling without try catch
			try {
				//Long a=10/cust_id;		//run with 0 id and empty db
			} catch (Exception e) {
				return new ResponseEntity<List<Cibil_check>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<List<Cibil_check>>(HttpStatus.NO_CONTENT); //run with 1 id and empty db
		}
		else {
			return new ResponseEntity<List<Cibil_check>>(list, HttpStatus.OK);
		}
	}
	
	//controller based exception handling
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> ArithmaticExceptionHandler(ArithmeticException a){
		return new ResponseEntity<String>("Arithmatic Exception Occurs", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PostMapping(value = "/postCibil")	//http://localhost:9027/cibil/postCibil
	public ResponseEntity<Cibil_check> saveCibil(@RequestBody Cibil_check c){
		Cibil_check c1=cs.saveCibil(c);	
		
		return new ResponseEntity<Cibil_check>(c1, HttpStatus.CREATED);
	}
	

}
