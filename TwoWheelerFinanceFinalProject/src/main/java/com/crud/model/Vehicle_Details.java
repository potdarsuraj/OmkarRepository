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
public class Vehicle_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vehicle_id;
	private String vehicleName;
	private double vehiclePrice;

}
