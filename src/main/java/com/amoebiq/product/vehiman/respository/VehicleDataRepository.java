package com.amoebiq.product.vehiman.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amoebiq.product.vehiman.model.ServiceDetails;
import com.amoebiq.product.vehiman.model.VehicleData;

@Repository
public interface VehicleDataRepository extends JpaRepository<VehicleData,Long>{
	
	@Query("SELECT DISTINCT v.type FROM VehicleData v where v.make = :make") 
    List<String> findTypeByMake(@Param("make") String make);
	
	@Query("SELECT DISTINCT v.make FROM VehicleData v where v.numOfWheels = :wheel") 
    List<String> findMakeByWheels(@Param("wheel") int wheel);
	
	@Query("SELECT DISTINCT v.numOfWheels FROM VehicleData v") 
    List<Integer> findAllWheels();

}
