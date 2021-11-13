package com.amoebiq.product.vehiman.controller;

import com.amoebiq.product.vehiman.model.EntityService;
import com.amoebiq.product.vehiman.model.ProductEntity;
import com.amoebiq.product.vehiman.service.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/entity")
public class ProductEntityController {

    @Autowired
    private ProductEntityService productEntityService;

    @PostMapping()
    public ResponseEntity<ProductEntity> newProductEntity(@RequestBody ProductEntity productEntity) {
        return new ResponseEntity<>(productEntityService.save(productEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProductEntities() {
        return new ResponseEntity<>(productEntityService.getAllEntities(),HttpStatus.OK);
    }

    @PostMapping(value = "{entityId}/service")
    public ResponseEntity<EntityService> newEntityService(@RequestBody EntityService entityService, @PathVariable("entityId")UUID entityId) {
        return new ResponseEntity<>(productEntityService.saveProductEntityService(entityService,entityId),HttpStatus.CREATED);
    }
}
