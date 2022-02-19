package com.crud.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data		//(equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode)
public class Customer_Primary_Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long cust_primary_id;
	
	private String cust_dob;
	private String cust_name;
	private String lan_no;
	private String cust_pan;
	private String cust_mob;
	private String cust_address;
	private String cust_Email;	
	private String cust_gender;	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bank_Details bankData;

	@OneToOne(cascade = CascadeType.ALL)
	private Vehicle_Details vehicleData;
	
}
