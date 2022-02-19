package com.crud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.exception.CustomerNotFoundException;
import com.crud.model.Customer_Primary_Data;
import com.crud.repository.CustomerRepository;

import com.crud.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public List<Customer_Primary_Data> viewCustomer() {
		List<Customer_Primary_Data> ls=null;
		log.info("in service Impl get Customer");
		
	        try {
	    		   ls=cr.findAll();
			} catch (Exception e) { 
				throw new CustomerNotFoundException("Customer Not Available");
			}
		
		return ls;
	}

	@Override
	public Customer_Primary_Data saveCustomer(Customer_Primary_Data c) {
		
		return cr.save(c);
	}

	@Override
	public void deleteData(Long cust_primary_id) {
		cr.deleteById(cust_primary_id);	
	}

	@Override
	public Optional<Customer_Primary_Data> editById(Long id) {
		Optional<Customer_Primary_Data> oc;
		try {
			oc=cr.findById(id);
			if(oc.isPresent())
			{
				return oc;
			}
			else {
				throw new CustomerNotFoundException("customer Id not found in try block");
			}
		} catch (Exception e) {
			throw new CustomerNotFoundException("customer Id not found in catch block");
		}
	}

	@Override
	public Customer_Primary_Data updateData(Long id, Customer_Primary_Data c) {
		Customer_Primary_Data c1=cr.findById(id).get();
		
		c1.setCust_primary_id(c.getCust_primary_id());
		c1.setCust_dob(c.getCust_dob());
		c1.setLan_no(c.getLan_no());
		c1.setCust_pan(c.getCust_pan());
		c1.setCust_mob(c.getCust_mob());
		c1.setCust_address(c.getCust_address());
		c1.setCust_Email(c.getCust_Email());
		c1.setCust_gender(c.getCust_gender());
		
		c1.setBankData(c.getBankData());
		c1.setVehicleData(c.getVehicleData());
		
		return cr.save(c1);
	}


}
