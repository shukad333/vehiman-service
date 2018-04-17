package com.amoebiq.product.vehiman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.service.AuthService;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(value="/signin")
	public ResponseEntity<Owner> signInOrSignUp(@RequestBody Owner owner) {
		
		Owner resp = authService.signInOrSignUp(owner);
		if(null!=resp) {
			return new ResponseEntity<Owner>(resp,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Owner>(resp,HttpStatus.BAD_REQUEST);
		}
	}
	
}
