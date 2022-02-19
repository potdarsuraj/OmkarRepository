package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.model.Customer_Primary_Data;

public interface CustomerService {

	List<Customer_Primary_Data> viewCustomer();

	Customer_Primary_Data saveCustomer(Customer_Primary_Data c);

	void deleteData(Long cust_primary_id);

	Optional<Customer_Primary_Data> editById(Long id);

	Customer_Primary_Data updateData(Long id, Customer_Primary_Data c);
}
