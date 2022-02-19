package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data	

public class Bank_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bank_Id;
	private String bankName;
	private String accountNo;
	private String ifscCode;
	private String micrCode;
	private String branch;

}
