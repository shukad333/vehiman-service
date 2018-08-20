package com.amoebiq.product.vehiman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amoebiq.product.vehiman.model.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long>{

}
