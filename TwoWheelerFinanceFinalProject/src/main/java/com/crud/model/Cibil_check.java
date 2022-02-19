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
public class Cibil_check {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cibil_id;
	private int cibil_score;
	private String cibil_status;

}
