package com.products.CatalogMicroservice.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_marca")
    private String name;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public void setProducts(Set<Product> products){
        this.products = products;
        for(Product product: products){
            product.setMarca(this);
        }
    }


}
