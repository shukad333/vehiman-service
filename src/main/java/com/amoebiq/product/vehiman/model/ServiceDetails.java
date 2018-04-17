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

/**
 * 
 * @author shukad333
 *
 */
@Entity
@Table(name = "service_details")
public class ServiceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "service_type")
	private String serviceType;
	
	@Column(name = "is_done",nullable = false, columnDefinition = "TINYINT", length = 1)
	private Boolean done;
	
	@Column(name="due_date")
	@JsonFormat(pattern = "dd-MMM-yyyy")
	private Date dueDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id",nullable=false)
	@JsonBackReference
	private Owner owner;
	
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
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
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
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	

}
