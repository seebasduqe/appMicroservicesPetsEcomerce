package com.petApp.basketService.entity;

import com.sun.istack.NotNull;
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
@Table(name = "order_for_client")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name_client;

    @NotNull
    private String address;

    @NotNull
    private String cel_no;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<DetailsProduct> products = new HashSet<>();

    @NotNull
    private Float total;


    public void setProducts(Set<DetailsProduct> products) {
        this.products = products;
        for(DetailsProduct detailsProduct : products){
            detailsProduct.setOrder(this);
        }
    }
}
