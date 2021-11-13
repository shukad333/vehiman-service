package com.amoebiq.product.vehiman.repository;

import com.amoebiq.product.vehiman.model.EntityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EntityServiceRepository extends JpaRepository<EntityService, UUID> {

    @Query("SELECT v FROM EntityService v where v.entity.id = :entityId")
    List<EntityService> findByEntityId(@Param("entityId") UUID entityId);

}
