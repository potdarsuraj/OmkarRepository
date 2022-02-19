package com.crud.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crud.model.Customer_Primary_Data;
import com.crud.model.Document;
import com.crud.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/customer")    //http://localhost:9999/customer/

public class HomeController {

	@Autowired
	CustomerService cs;
	
	@GetMapping(value = "/getCustomerAllData")	//http://localhost:9999/customer/getCustomerAllData
	public ResponseEntity<List<Customer_Primary_Data>> getCustomer()
	{
		log.info("checking cust_primary method calling using @Slf4j :");
		List<Customer_Primary_Data> list=cs.viewCustomer();
		if(list.isEmpty())
		{
			//Long b=20/pid; //for controller based exception handling without try catch
			try {
				//Long a=10/cust_primary_id;		//run with 0 id and empty db
			} catch (Exception e) {
				return new ResponseEntity<List<Customer_Primary_Data>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<List<Customer_Primary_Data>>(HttpStatus.NO_CONTENT); //run with 1 id and empty db
		}
		else {
			return new ResponseEntity<List<Customer_Primary_Data>>(list, HttpStatus.OK);
		}
	}
	
	//controller based exception handling
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> ArithmaticExceptionHandler(ArithmeticException a){
		return new ResponseEntity<String>("Arithmatic Exception Occurs", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@PostMapping(value = "/postCustomer")	//http://localhost:9999/customer/postCustomer
	public ResponseEntity<Customer_Primary_Data> saveCustomer(@RequestBody Customer_Primary_Data c){
		Customer_Primary_Data c1=cs.saveCustomer(c);	// 
		
		return new ResponseEntity<Customer_Primary_Data>(c1, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(value = "/deleteCustomer/{cust_primary_id}")	//http://localhost:9999/customer/deleteCustomer/2
	public ResponseEntity<String> deleteCustomer(@PathVariable("cust_primary_id") Long cust_primary_id)		//must use id for delete
	{
		cs.deleteData(cust_primary_id);
		return new ResponseEntity<String>("delete Data Successfully ", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getCustById/{cust_primary_id}")		//http://localhost:9999/customer/getCustById/7
	public ResponseEntity<Optional<Customer_Primary_Data>> getProByid(@PathVariable("cust_primary_id") Long id)
	{
		Optional<Customer_Primary_Data> op=cs.editById(id);
		return new ResponseEntity<Optional<Customer_Primary_Data>>(op, HttpStatus.OK);
	}
	
	@PutMapping("/updateCustById/{cust_primary_id}")		//http://localhost:9999/customer/updateCustById/2
	public ResponseEntity<String> updateCustById(@PathVariable ("cust_primary_id") Long id, @RequestBody Customer_Primary_Data c) 
	{
		Optional<Customer_Primary_Data> up=cs.editById(id);	
		Customer_Primary_Data ct=cs.updateData(id, c);
				
		return new ResponseEntity<String>("Updated Successfully", HttpStatus.CREATED);
	}
	
	
	
	
}
