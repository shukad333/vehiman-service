package com.amoebiq.product.vehiman.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author shukad333
 *
 */
@Entity
@Table(name = "service_details")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ServiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "service_type")
	private String serviceType;
	
	@Column(name = "is_done",nullable = false, columnDefinition = "TINYINT", length = 1)
	private Boolean done;
	
	@Column(name="service_date")
	@JsonFormat(pattern = "dd-MMM-yyyy")
	private Date serviceDate;
	
	@Column(name="next_service_date")
	@JsonFormat(pattern = "dd-MMM-yyyy")
	private Date nextServiceDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vehicle_id",nullable=false)
	private Vehicle vehicle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id",nullable=false)
	@JsonBackReference(value="service_owner_ref")
	private Owner owner;
	
	
	public Date getNextServiceDate() {
		return nextServiceDate;
	}
	public void setNextServiceDate(Date nextServiceDate) {
		this.nextServiceDate = nextServiceDate;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	@Column(name="current_odo")
	private Long currentOdo;
	
	@Column(name="next_service_odo")
	private Long nextServiceOdo;
	
	
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	public Long getCurrentOdo() {
		return currentOdo;
	}
	public void setCurrentOdo(Long currentOdo) {
		this.currentOdo = currentOdo;
	}
	public Long getNextServiceOdo() {
		return nextServiceOdo;
	}
	public void setNextServiceOdo(Long nextServiceOdo) {
		this.nextServiceOdo = nextServiceOdo;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public Date getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}
	
	

}
