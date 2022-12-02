package com.petApp.basketService.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "details_product", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name_product"})
})
public class DetailsProduct {

    @Id
    private Long id;

    @NotNull
    private String name_product;
    @NotNull
    private String weight_product;
    @NotNull
    private Float price;
    @NotNull
    private Long stock;
    @NotNull
    private Float subtotal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    public DetailsProduct() {}

    public DetailsProduct(Long id, String name_product, String weight_product, Float price, Long stock, Float subtotal, Order order) {
        this.id = id;
        this.name_product = name_product;
        this.weight_product = weight_product;
        this.price = price;
        this.stock = stock;
        this.subtotal = subtotal;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getWeight_product() {
        return weight_product;
    }

    public void setWeight_product(String weight_product) {
        this.weight_product = weight_product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
