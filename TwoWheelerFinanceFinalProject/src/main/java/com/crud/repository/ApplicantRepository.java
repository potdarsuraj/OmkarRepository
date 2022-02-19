package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Applicant_Data;
import com.crud.model.Customer_Primary_Data;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant_Data, Long> {

}
