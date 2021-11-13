package com.amoebiq.product.vehiman.service;

import com.amoebiq.product.vehiman.model.EntityService;
import com.amoebiq.product.vehiman.model.ProductEntity;
import com.amoebiq.product.vehiman.repository.EntityServiceRepository;
import com.amoebiq.product.vehiman.repository.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductEntityService {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private EntityServiceRepository entityServiceRepository;

    public ProductEntity save(ProductEntity productEntity) {
        return productEntityRepository.save(productEntity);
    }

    public List<ProductEntity> getAllEntities() {
        return productEntityRepository.findAll();
    }



    public EntityService saveProductEntityService(EntityService entityService, UUID entityId) {
        ProductEntity entity = productEntityRepository.findById(entityId).orElse(null);
        entityService.setProductEntity(entity);
        return entityServiceRepository.save(entityService);
    }


    public List<EntityService> getEntityServicesByEntityId(UUID entityId) {

        return entityServiceRepository.findByEntityId(entityId);
    }
}
