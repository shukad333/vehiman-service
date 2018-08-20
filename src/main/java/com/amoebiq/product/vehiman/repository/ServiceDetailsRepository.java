package com.amoebiq.product.vehiman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amoebiq.product.vehiman.model.ServiceDetails;
import com.amoebiq.product.vehiman.model.Vehicle;

@Repository
public interface ServiceDetailsRepository extends JpaRepository<ServiceDetails, Long>{
	
	@Query("SELECT s FROM ServiceDetails s where s.owner.id = :ownerId") 
    List<ServiceDetails> findByOwner(@Param("ownerId") long ownerId);

}
