package com.amoebiq.product.vehiman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="owner_id")
	private Long ownerId;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="type")
	private String type;
	
	@Column(name="model")
	private String model;
	
	
	
}
