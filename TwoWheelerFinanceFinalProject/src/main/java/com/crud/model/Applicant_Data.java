package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Applicant_Data {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long cust_id;
	private String cust_dob;
	private String cust_name;
	private String lan_no;
	private String cust_pan;
	private String cust_mob;
	private String cust_address;
	private String cust_Email;
	private String cust_gender;


}
