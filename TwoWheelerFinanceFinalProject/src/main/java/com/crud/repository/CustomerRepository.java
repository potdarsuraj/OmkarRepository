package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Customer_Primary_Data;

@Repository
public interface CustomerRepository extends JpaRepository<Customer_Primary_Data, Long> {

}
