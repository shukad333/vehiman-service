package com.amoebiq.product.vehiman.controller.utils;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtils {
	
	private static final Logger logger = LogManager.getLogger(BeanUtils.class);
	public static Set<String> getNullPropertyNames (Object source,String... extra) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) {
	        	logger.info("attribute {}",pd.getName());
	        	emptyNames.add(pd.getName());
	        }
	    }
	    
	    for(String args : extra) {
	    	emptyNames.add(args);
	    }
	    return emptyNames;
	}
	
}
