package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.model.ApprovedCases;

public interface ApprovedService {

	List<ApprovedCases> viewApproved();

	ApprovedCases saveApproved(ApprovedCases a);

	void deleteData(Long case_id);

	Optional<ApprovedCases> editById(Long id);

	ApprovedCases updateData(Long id, ApprovedCases a);


}
