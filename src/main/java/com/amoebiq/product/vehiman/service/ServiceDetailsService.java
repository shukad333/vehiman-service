package com.amoebiq.product.vehiman.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amoebiq.product.vehiman.model.Owner;
import com.amoebiq.product.vehiman.model.ServiceDetails;
import com.amoebiq.product.vehiman.respository.OwnerRepository;
import com.amoebiq.product.vehiman.respository.ServiceDetailsRepository;

@Service
public class ServiceDetailsService {

	private static Logger logger = LogManager.getLogger(ServiceDetails.class);

	@Autowired
	private ServiceDetailsRepository serviceDetailsRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	public List<ServiceDetails> getAllServiceDetails() {
		return serviceDetailsRepository.findAll();
	}

	public List<ServiceDetails> getAllServiceDetailsOfOwner(String email) {
		Owner owner = ownerRepository.getOwnerByEmail(email);
		if(null!=owner)
		return serviceDetailsRepository.findByOwner(owner.getId());
		
		return null;
	}

	public List<ServiceDetails> addServiceDetail(String email, List<ServiceDetails> serviceDetails) {

		logger.info("In add service details");
		Owner owner = ownerRepository.getOwnerByEmail(email);
		if (null != owner) {
			if (!CollectionUtils.isEmpty(serviceDetails)) {
				for (ServiceDetails serviceDetail : serviceDetails) {
					serviceDetail.setOwner(owner);
					logger.info("Current odo {}", serviceDetail.getCurrentOdo());
				}
				serviceDetailsRepository.saveAll(serviceDetails);
			}
		}
		
		if(null != owner)
		return serviceDetailsRepository.findByOwner(owner.getId());
		
		return null;
	}

	public ServiceDetails editServiceDetails(long serviceId, ServiceDetails serviceDetails) {
		if (null != serviceDetails) {
			logger.info("Service id for editing :::{}",serviceId);
			ServiceDetails service = serviceDetailsRepository.findById(serviceId).orElse(null);
			if (null != service) {
				logger.info("Copying from source to target");
				Set<String> ignoreFields = com.amoebiq.product.vehiman.controller.utils.BeanUtils.getNullPropertyNames(serviceDetails,"id","owner");
				BeanUtils.copyProperties(serviceDetails, service,ignoreFields.toArray(new String[ignoreFields.size()]));
				serviceDetailsRepository.save(service);
				return service;
			}
		}

		return null;

	}
}
