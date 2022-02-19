package com.crud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.exception.CustomerNotFoundException;
import com.crud.model.ApprovedCases;

import com.crud.repository.ApprovedRepository;

import com.crud.service.ApprovedService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApprovedServiceImpl implements ApprovedService{

	@Autowired
	ApprovedRepository ar;

	@Override
	public List<ApprovedCases> viewApproved() {
		List<ApprovedCases> ls=null;
		log.info("in service Impl get Applicant");
		
	        try {
	    		   ls=ar.findAll();
			} catch (Exception e) { 
				throw new CustomerNotFoundException("Applicant Not Available");
			}
		return ls;
	}

	@Override
	public ApprovedCases saveApproved(ApprovedCases a) {
		
		return ar.save(a);
	}

	@Override
	public void deleteData(Long case_id) {
		ar.deleteById(case_id);		
	}

	@Override
	public Optional<ApprovedCases> editById(Long id) {
		Optional<ApprovedCases> oc;
		try {
			oc=ar.findById(id);
			if(oc.isPresent())
			{
				return oc;
			}
			else {
				throw new CustomerNotFoundException("ApprovedCases Id not found in try block");
			}
		} catch (Exception e) {
			throw new CustomerNotFoundException("ApprovedCases Id not found in catch block");
		}
	}

	@Override
	public ApprovedCases updateData(Long id, ApprovedCases a) {
		
		ApprovedCases c1=ar.findById(id).get();
		
		c1.setCase_id(a.getCase_id());
		c1.setLan_no(a.getLan_no());
		c1.setLoanAmount(a.getLoanAmount());
		c1.setRoi(a.getRoi());
		c1.setTenure(a.getTenure());
		c1.setDate(a.getDate());
		
		return ar.save(c1);
	}

}
