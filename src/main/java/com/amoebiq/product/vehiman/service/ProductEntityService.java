package com.amoebiq.product.vehiman.service;

import com.amoebiq.product.vehiman.model.ProductEntity;
import com.amoebiq.product.vehiman.repository.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductEntityService {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    public ProductEntity save(ProductEntity productEntity) {
        return productEntityRepository.save(productEntity);
    }

    public List<ProductEntity> getAllEntities() {
        return productEntityRepository.findAll();
    }
}
