package com.amoebiq.product.vehiman.repository;

import com.amoebiq.product.vehiman.model.EntityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EntityServiceRepository extends JpaRepository<EntityService, UUID> {
}
