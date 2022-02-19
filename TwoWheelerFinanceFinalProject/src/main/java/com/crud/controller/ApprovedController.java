package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.crud.model.ApprovedCases;
import com.crud.service.ApprovedService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/approved")    //http://localhost:9027/approved/

public class ApprovedController {

	@Autowired
	ApprovedService as;
					
	@GetMapping(value = "/getApprovedData")	//http://localhost:9027/approved/getApprovedData
	public ResponseEntity<List<ApprovedCases>> getApproved()
	{
		log.info("checking method calling using @Slf4j :");
		List<ApprovedCases> list=as.viewApproved();
		if(list.isEmpty())
		{
			//Long b=20/pid; //for controller based exception handling without try catch
			try {
				//Long a=10/cust_id;		//run with 0 id and empty db
			} catch (Exception e) {
				return new ResponseEntity<List<ApprovedCases>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<List<ApprovedCases>>(HttpStatus.NO_CONTENT); //run with 1 id and empty db
		}
		else {
			return new ResponseEntity<List<ApprovedCases>>(list, HttpStatus.OK);
		}
	}
	
	//controller based exception handling
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> ArithmaticExceptionHandler(ArithmeticException a){
		return new ResponseEntity<String>("Arithmatic Exception Occurs", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@PostMapping(value = "/postApproved")	//http://localhost:9027/approved/postApproved
	public ResponseEntity<ApprovedCases> saveApproved(@RequestBody ApprovedCases a){
		ApprovedCases c1=as.saveApproved(a);	
		
		return new ResponseEntity<ApprovedCases>(c1, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(value = "/deleteApproved/{case_id}")	//http://localhost:9027/approved/deleteApproved/2
	public ResponseEntity<String> deleteApproved(@PathVariable("case_id") Long case_id)		//must use id for delete
	{
		as.deleteData(case_id);
		return new ResponseEntity<String>("delete Data Successfully ", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getApprovedById/{case_id}")		//http://localhost:9027/approved/getApprovedById/7
	public ResponseEntity<Optional<ApprovedCases>> getApprovedByid(@PathVariable("case_id") Long id)
	{
		Optional<ApprovedCases> op=as.editById(id);
		return new ResponseEntity<Optional<ApprovedCases>>(op, HttpStatus.OK);
	}
	
	@PutMapping("/updateById/{case_id}")		//http://localhost:9027/approved/updateById/2
	public ResponseEntity<String> updateApprovedById(@PathVariable ("case_id") Long id, @RequestBody ApprovedCases a) 
	{
		Optional<ApprovedCases> up=as.editById(id);	
		ApprovedCases ct=as.updateData(id, a);
				
		return new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
	}
	    	
	    
	
}
