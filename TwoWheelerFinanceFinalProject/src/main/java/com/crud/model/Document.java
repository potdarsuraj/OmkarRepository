package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long doc_id;
	
	@Column
	private long cust_primary_id;
	@Lob
	private byte[] aadharCard;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] incomeProof;
	@Lob
	private byte[] cancledCheque;
	@Lob
	private byte[] photo;

}
