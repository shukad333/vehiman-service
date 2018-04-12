package com.amoebiq.product.vehiman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.ServiceType;
import com.amoebiq.product.vehiman.respository.ServiceTypeRepository;

@Service
public class ServiceTypeService {
	
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;
	
	public List<ServiceType> getAllServices() {
		
		return serviceTypeRepository.findAll();
		
	}
}
