package com.crud.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.exception.CustomerNotFoundException;
import com.crud.model.Cibil_check;
import com.crud.repository.CibilRepository;
import com.crud.service.CibilService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CibilServiceImpl implements CibilService{

	@Autowired
	CibilRepository cr;

	@Override
	public List<Cibil_check> viewCibil() {
		List<Cibil_check> ls=null;
		log.info("in service Impl get Customer");
		
	        try {
	    		   ls=cr.findAll();
			} catch (Exception e) { 
				throw new CustomerNotFoundException("Cibil Not Available");
			}
		
		return ls;
	}

	@Override
	public Cibil_check saveCibil(Cibil_check c) {
		
		return cr.save(c);
	}

	


}
