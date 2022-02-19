package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.model.Applicant_Data;

public interface ApplicantService {

	List<Applicant_Data> viewApplicant();

	Applicant_Data saveApplicant(Applicant_Data a);

	void deleteData(Long cust_primary_id);

	Optional<Applicant_Data> editById(Long id);

	Applicant_Data updateData(Long id, Applicant_Data a);

	

}
