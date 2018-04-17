package com.amoebiq.product.vehiman.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.model.Vehicle;
import com.amoebiq.product.vehiman.respository.OwnerRepository;
import com.amoebiq.product.vehiman.respository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public List<Vehicle> getVehiclesByOwner(String email) {
		Owner owner = ownerRepository.getOwnerByEmail(email);
		if(null != owner) {
		return vehicleRepository.findByOwner(owner.getId());
		}
		return null;
	}
	
	public Owner addVehiclesToOwner(String email,List<Vehicle> vehicles) {
		Owner owner = ownerRepository.getOwnerByEmail(email);
		if(null!=owner) {
			if(!CollectionUtils.isEmpty(vehicles)) {
				for(Vehicle vehicle : vehicles) {
					vehicle.setOwner(owner);
					vehicleRepository.save(vehicle);
				}
			}
		}
		return ownerRepository.getOwnerByEmail(email);
	}
	
}
