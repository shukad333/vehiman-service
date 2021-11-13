package com.amoebiq.product.vehiman.repository;

import com.amoebiq.product.vehiman.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity,Long> {
}
