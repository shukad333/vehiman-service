package com.amoebiq.product.vehiman.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="entity")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String name;

    @Column
    private boolean active;

    @Column
    private String type;

    @OneToMany(mappedBy = "entity",cascade=CascadeType.ALL)
    @JsonBackReference(value="entity_service_ref")
    private Set<EntityService> entityServices =  new HashSet<>();



    @Column(name = "sub_type")
    private String subType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }


    public Set<EntityService> getEntityServices() {
        return entityServices;
    }

    public void setEntityServices(Set<EntityService> entityServices) {
        this.entityServices = entityServices;
    }
}
