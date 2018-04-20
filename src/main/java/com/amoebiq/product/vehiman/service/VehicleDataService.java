package com.amoebiq.product.vehiman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.VehicleData;
import com.amoebiq.product.vehiman.respository.VehicleDataRepository;

@Service
public class VehicleDataService {
	
	@Autowired
	private VehicleDataRepository vehicleDataRepository;
	
	public List<String> getAllMakeByWheel(int wheel) {
		
		return vehicleDataRepository.findMakeByWheels(wheel);
	}
	
	public List<String> getAllTypeByMake(String make) {
		return vehicleDataRepository.findTypeByMake(make);
	}
	
	public List<Integer> getAllWheels() {
		return vehicleDataRepository.findAllWheels();
	}
	
}
