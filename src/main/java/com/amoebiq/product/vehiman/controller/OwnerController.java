package com.amoebiq.product.vehiman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.model.Vehicle;
import com.amoebiq.product.vehiman.service.OwnerService;
import com.amoebiq.product.vehiman.service.VehicleService;

@RestController
@RequestMapping(path="/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping(value="/add")
	public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
		
		return new ResponseEntity<Owner>(ownerService.addOwner(owner),HttpStatus.CREATED);
	}
	
	@GetMapping(value="{ownerId}/vehicles")
	public ResponseEntity<List<Vehicle>> getVehiclesOfOwner(@PathVariable("ownerId") long ownerId) {
		
		return new ResponseEntity<List<Vehicle>>(vehicleService.getVehiclesByOwner(ownerId),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value="{ownerId}/vehicles")
	public ResponseEntity<Owner> addVehicles(@PathVariable("ownerId") long ownerId,@RequestBody List<Vehicle> vehicles) {
		return new ResponseEntity<Owner>(vehicleService.addVehiclesToOwner(ownerId, vehicles),HttpStatus.ACCEPTED);
	}
}
