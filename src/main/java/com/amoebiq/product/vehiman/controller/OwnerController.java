package com.amoebiq.product.vehiman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.service.OwnerService;

@RestController
@RequestMapping(path="/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@PostMapping(value="/add")
	public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
		
		return new ResponseEntity<Owner>(ownerService.addOwner(owner),HttpStatus.CREATED);
	}
}
