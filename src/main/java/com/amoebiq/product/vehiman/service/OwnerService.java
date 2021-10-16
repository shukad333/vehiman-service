package com.amoebiq.product.vehiman.service;

import com.amoebiq.product.vehiman.controller.utils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.repository.OwnerRepository;

import java.util.List;

@Service
public class OwnerService {
	private static final Logger logger = LogManager.getLogger(OwnerService.class);
	@Autowired
	private OwnerRepository ownerRepository;
	
	public Owner addOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	public Owner getDetails(String email) {
		logger.info("XXX email is {}",email);
		logger.info("emails is {}",ownerRepository.getOwnerByEmail(email));
		return ownerRepository.getOwnerByEmail(email);
	}


	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}
	

}
