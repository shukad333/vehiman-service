package com.amoebiq.product.vehiman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.respository.OwnerRepository;

@Service
public class OwnerService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public Owner addOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	public Owner getDetails(String email) {
		return ownerRepository.getOwnerByEmail(email);
	}
	

}
