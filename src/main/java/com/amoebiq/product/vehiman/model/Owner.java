package com.amoebiq.product.vehiman.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//Comm1
@Entity
@Table(name="owner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String gender;
	
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonManagedReference(value="vehicle_owner_ref")
	private Set<Vehicle> vehicles = new HashSet<>();
	
	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL,orphanRemoval=true)
	@JsonManagedReference(value="service_owner_ref")
	private Set<ServiceDetails> services = new HashSet<>();

	public Set<ServiceDetails> getServices() {
		return services;
	}

	public void setServices(Set<ServiceDetails> services) {
		this.services = services;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
		for(Vehicle vehicle : vehicles) {
			vehicle.setOwner(this);
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
