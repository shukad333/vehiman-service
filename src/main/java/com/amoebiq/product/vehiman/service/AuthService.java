package com.amoebiq.product.vehiman.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.respository.OwnerRepository;

@Service
public class AuthService {
	
	private static final Logger logger = LogManager.getLogger(AuthService.class);
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public Owner signInOrSignUp(Owner owner) {
		
		String emailId = owner.getEmail();
		if(null != emailId) { 
		Owner existing = ownerRepository.getOwnerByEmail(emailId);
		if(null == existing) {
			logger.debug("Owner is empty , hence creating new");
			ownerRepository.save(owner);
			return owner;
		}
		else {
			return owner;
		}
		}
		
		return null;
	}
}
