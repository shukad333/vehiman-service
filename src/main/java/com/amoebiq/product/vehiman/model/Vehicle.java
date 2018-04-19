package com.amoebiq.product.vehiman.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="vehicles")
public class Vehicle {
	public Set<ServiceDetails> getServices() {
		return services;
	}

	public void setServices(Set<ServiceDetails> services) {
		this.services = services;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="type")
	private String type;
	
	@Column(name="number")
	private String number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id",nullable=false)
	@JsonBackReference(value="vehicle_owner_ref")
	private Owner owner;
	
	@OneToMany(mappedBy="vehicle",cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonBackReference(value="service_ref")
	private Set<ServiceDetails> services;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String model) {
		this.number = model;
	}
	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
		
	}
	
	
}
