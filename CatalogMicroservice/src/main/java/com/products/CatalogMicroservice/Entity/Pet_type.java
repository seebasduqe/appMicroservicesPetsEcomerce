package com.products.CatalogMicroservice.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pet_type")
public class Pet_type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name_pet_type;

    @OneToMany(mappedBy = "pet_type", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_pet_type() {
        return name_pet_type;
    }

    public void setName_pet_type(String name_pet_type) {
        this.name_pet_type = name_pet_type;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
        for(Product product: products){
            product.setPet_type(this);
        }
    }
}
