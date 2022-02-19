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
public class ApprovedCases {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long case_id;
	private String lan_no;
	private double loanAmount;
	private long roi;
	private long tenure;
	private String date;
	
//	@Temporal(TemporalType.DATE)
//	private Date date = new Date(System.currentTimeMillis());

}
