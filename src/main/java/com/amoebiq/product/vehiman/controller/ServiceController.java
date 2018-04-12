package com.amoebiq.product.vehiman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.product.vehiman.model.ServiceDetails;
import com.amoebiq.product.vehiman.service.ServiceDetailsService;

@RestController
@RequestMapping(path = "/service")
public class ServiceController {

	@Autowired
	private ServiceDetailsService serviceDetailsService;

	@GetMapping(value = "/details/all")
	public ResponseEntity<List<ServiceDetails>> getAllServiceDetails() {

		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.getAllServiceDetails(),
				HttpStatus.ACCEPTED);

	}
	
	@PutMapping(value="{serviceId}")
	public ResponseEntity<ServiceDetails> editServiceDetail(@PathVariable("serviceId") long serviceId,@RequestBody ServiceDetails serviceDetails) {
		
		ServiceDetails serviceDetail = serviceDetailsService.editServiceDetails(serviceId,serviceDetails);
		if(null!=serviceDetail) {
			return new ResponseEntity<ServiceDetails>(serviceDetail,HttpStatus.CREATED);
		}
		
		return new ResponseEntity<ServiceDetails>(new ServiceDetails(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
