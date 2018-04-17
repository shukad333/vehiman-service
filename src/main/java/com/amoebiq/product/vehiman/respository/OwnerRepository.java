package com.amoebiq.product.vehiman.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amoebiq.product.vehiman.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{
	
	@Query("SELECT o FROM Owner o where o.email = :emailId")
	Owner getOwnerByEmail(@Param("emailId") String email);

}
