package com.amoebiq.product.vehiman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.product.vehiman.model.ServiceType;
import com.amoebiq.product.vehiman.service.ServiceTypeService;

@RestController
@RequestMapping(value = "/config")
public class ConfigController {

	@Autowired
	private ServiceTypeService serviceTypeService;

	@GetMapping(value = "/serviceTypes")
	public ResponseEntity<List<ServiceType>> getAllServiceTypes() {

		return new ResponseEntity<List<ServiceType>>(serviceTypeService.getAllServices(), HttpStatus.ACCEPTED);
	}

}
