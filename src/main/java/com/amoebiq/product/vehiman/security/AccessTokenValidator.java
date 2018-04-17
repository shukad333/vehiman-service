package com.amoebiq.product.vehiman.security;

public interface AccessTokenValidator {
	
	AccessTokenValidationResult validate(String accessToken);
}
