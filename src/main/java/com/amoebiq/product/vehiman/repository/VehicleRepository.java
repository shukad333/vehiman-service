package com.amoebiq.product.vehiman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amoebiq.product.vehiman.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	    @Query("SELECT v FROM Vehicle v where v.owner.id = :ownerId") 
	    List<Vehicle> findByOwner(@Param("ownerId") long ownerId);
}
