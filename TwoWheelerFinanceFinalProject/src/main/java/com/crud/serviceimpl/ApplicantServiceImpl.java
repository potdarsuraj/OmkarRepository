package com.crud.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.exception.CustomerNotFoundException;
import com.crud.model.Applicant_Data;
import com.crud.repository.ApplicantRepository;
import com.crud.service.ApplicantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApplicantServiceImpl implements ApplicantService{

	@Autowired
	ApplicantRepository ar;

	@Override
	public List<Applicant_Data> viewApplicant() {
		List<Applicant_Data> ls=null;
		log.info("in service Impl get Applicant");
		
	        try {
	    		   ls=ar.findAll();
			} catch (Exception e) { 
				throw new CustomerNotFoundException("Applicant Not Available");
			}
		
		return ls;
	}

	@Override
	public Applicant_Data saveApplicant(Applicant_Data a) {
		
		return ar.save(a);
	}

	@Override
	public void deleteData(Long id) {
		ar.deleteById(id);		
	}

	@Override
	public Optional<Applicant_Data> editById(Long id) {
		Optional<Applicant_Data> oc;
		try {
			oc=ar.findById(id);
			if(oc.isPresent())
			{
				return oc;
			}
			else {
				throw new CustomerNotFoundException("applicant Id not found in try block");
			}
		} catch (Exception e) {
			throw new CustomerNotFoundException("customer Id not found in catch block");
		}
	}

	@Override
	public Applicant_Data updateData(Long id, Applicant_Data a) {
		Applicant_Data c1=ar.findById(id).get();
		
		c1.setCust_id(a.getCust_id());
		c1.setCust_address(a.getCust_address());
		c1.setCust_dob(a.getCust_dob());
		c1.setCust_Email(a.getCust_Email());
		c1.setCust_gender(a.getCust_gender());
		c1.setCust_mob(a.getCust_mob());
		c1.setCust_name(a.getCust_name());
		c1.setCust_pan(a.getCust_pan());
		c1.setLan_no(a.getLan_no());
		
		return ar.save(c1);
	}


}
