package com.amoebiq.product.vehiman.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.product.vehiman.model.ServiceType;
import com.amoebiq.product.vehiman.repository.VehicleDataRepository;
import com.amoebiq.product.vehiman.service.ServiceTypeService;
import com.amoebiq.product.vehiman.service.VehicleDataService;

@RestController
@RequestMapping(value = "/config")
public class ConfigController {

	@Autowired
	private ServiceTypeService serviceTypeService;
	
	@Autowired
	private VehicleDataService vehicleDataService;
	
	@GetMapping(value = "/serviceTypes")
	public ResponseEntity<List<ServiceType>> getAllServiceTypes() {

		return new ResponseEntity<List<ServiceType>>(serviceTypeService.getAllServices(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/vehicle/make/{wheel}")
	public ResponseEntity<List<String>> getAllMakes(@PathVariable("wheel") int wheel) {
		
		return new ResponseEntity<List<String>>(vehicleDataService.getAllMakeByWheel(wheel),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value="/vehicle/type/{make}")
	public ResponseEntity<List<String>> getAllTypes(@PathVariable("make") String make) {
		
		return new ResponseEntity<List<String>>(vehicleDataService.getAllTypeByMake(make),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value="/vehicle/wheel")
	public ResponseEntity<List<Integer>> getAllWheels() {
		
		return new ResponseEntity<List<Integer>>(vehicleDataService.getAllWheels(),HttpStatus.ACCEPTED);
		
	}

}
