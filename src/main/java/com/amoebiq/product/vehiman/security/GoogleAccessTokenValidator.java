package com.amoebiq.product.vehiman.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.LogManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.util.Assert;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableMap;

public class GoogleAccessTokenValidator implements AccessTokenValidator, InitializingBean {
	private String clientId;
	private String checkTokenUrl;
	
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(GoogleAccessTokenValidator.class);

	private RestTemplate restTemplate = new RestTemplate();

	public GoogleAccessTokenValidator() {
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				if (response.getRawStatusCode() == 400) {
					traceResponse(response);
					logger.error("Client Id {},{}",clientId,response.getBody());
					logger.error("Invalid token "+checkTokenUrl);
					throw new InvalidTokenException("The provided token is invalid");
				}
			}
		});
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.hasText(clientId, "clientId must not be blank");
		Assert.hasText(checkTokenUrl, "checkTokenUrl must not be blank");
	}

	@Override
	public AccessTokenValidationResult validate(String accessToken) {
		Map<String, ?> response = getGoogleResponse(accessToken);
		boolean validationResult = validateResponse(response);
		System.out.println("Valiadation result is "+validationResult);
		return new AccessTokenValidationResult(true, response);
	}

	private boolean validateResponse(Map<String, ?> response) throws AuthenticationException {
		for(Map.Entry<String, ?> entry : response.entrySet()) {
			
			System.out.println(entry.getKey()+"   "+entry.getValue());
		}
		String aud = (String) response.get("aud");
		
		System.out.println("Client id is "+clientId);
		if (!StringUtils.equals(aud, clientId)) {
			return false;
		}
		return true;
	}

	private Map<String, ?> getGoogleResponse(String accessToken) {
		HttpEntity<Object> requestEntity = new HttpEntity<>(new HttpHeaders());
		Map<String, String> variables = ImmutableMap.of("accessToken", accessToken);
		Map map = restTemplate.exchange(checkTokenUrl, HttpMethod.GET, requestEntity, Map.class, variables).getBody();
		return (Map<String, Object>) map;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setCheckTokenUrl(String checkTokenUrl) {
		this.checkTokenUrl = checkTokenUrl;
	}
	
	private void traceResponse(ClientHttpResponse response) throws IOException {
	    StringBuilder inputStringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
	    String line = bufferedReader.readLine();
	    while (line != null) {
	        inputStringBuilder.append(line);
	        inputStringBuilder.append('\n');
	        line = bufferedReader.readLine();
	    }
	    logger.error("============================response begin==========================================");
	    logger.error("Status code  : {}", response.getStatusCode());
	    logger.error("Status text  : {}", response.getStatusText());
	    logger.error("Headers      : {}", response.getHeaders());
	    logger.error("Response body: {}", inputStringBuilder.toString());
	    logger.debug("=======================response end=================================================");
	}
}
