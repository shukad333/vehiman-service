package com.amoebiq.product.vehiman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.model.ServiceDetails;
import com.amoebiq.product.vehiman.model.Vehicle;
import com.amoebiq.product.vehiman.service.OwnerService;
import com.amoebiq.product.vehiman.service.ServiceDetailsService;
import com.amoebiq.product.vehiman.service.VehicleService;

@RestController
@RequestMapping(path="/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ServiceDetailsService serviceDetailsService;
	
	@PostMapping(value="/add")
	public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
		
		return new ResponseEntity<Owner>(ownerService.addOwner(owner),HttpStatus.CREATED);
	}
	
	@GetMapping(value="{ownerId}")
	public ResponseEntity<Owner> getDetails(@PathVariable("ownerId") long ownerId) {
		
		return new ResponseEntity<Owner>(ownerService.getDetails(ownerId),HttpStatus.CREATED);
	}
	
	@GetMapping(value="{email}/vehicles")
	public ResponseEntity<List<Vehicle>> getVehiclesOfOwner(@PathVariable("email") String email) {
		
		Authentication holder = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(holder.getName()+"  "+holder.getPrincipal());
		return new ResponseEntity<List<Vehicle>>(vehicleService.getVehiclesByOwner(email),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="{email}/services")
	public ResponseEntity<List<ServiceDetails>> getServicesOfOwner(@PathVariable("email") String email) {
		
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.getAllServiceDetailsOfOwner(email),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value="{email}/vehicles")
	public ResponseEntity<Owner> addVehicles(@PathVariable("email") String email,@RequestBody List<Vehicle> vehicles) {
		return new ResponseEntity<Owner>(vehicleService.addVehiclesToOwner(email, vehicles),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value="{email}/services")
	public ResponseEntity<List<ServiceDetails>> addServices(@PathVariable("email") String email,@RequestBody List<ServiceDetails> services) {
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.addServiceDetail(email, services),HttpStatus.ACCEPTED);
	}

}
