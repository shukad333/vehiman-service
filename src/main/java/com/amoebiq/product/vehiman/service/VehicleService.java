package com.amoebiq.product.vehiman.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.model.Vehicle;
import com.amoebiq.product.vehiman.repository.OwnerRepository;
import com.amoebiq.product.vehiman.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public List<Vehicle> getVehiclesByOwner(String email) {
		System.out.println("Email is XXXXX "+email);
		Owner owner = ownerRepository.getOwnerByEmail(email);
		System.out.println("XXXX Owner is "+owner.getId());
		if(null != owner) {
		return vehicleRepository.findByOwner(owner.getId());
		}
		return null;
	}
	
	public Vehicle addVehiclesToOwner(String email,Vehicle vehicle) {
		Owner owner = ownerRepository.getOwnerByEmail(email);
		vehicle.setOwner(owner);
		return vehicleRepository.save(vehicle);


	}
	
}
