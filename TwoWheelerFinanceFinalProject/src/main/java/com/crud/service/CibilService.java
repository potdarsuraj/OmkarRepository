package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.model.Applicant_Data;
import com.crud.model.Cibil_check;

public interface CibilService {

	List<Cibil_check> viewCibil();

	Cibil_check saveCibil(Cibil_check c);


	

}
