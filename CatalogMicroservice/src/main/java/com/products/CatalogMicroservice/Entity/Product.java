package com.products.CatalogMicroservice.Entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name_product"})
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name_product;

    private String description_product;

    //peso
    private String weight_product;

    private Float priceB_product;

    private Float priceS_product;

    private Long stock_product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pet_type_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Pet_type pet_type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "marca_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Marca marca;

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

    public String getDescription_product() {
        return description_product;
    }

    public void setDescription_product(String description_product) {
        this.description_product = description_product;
    }

    public String getWeight_product() {
        return weight_product;
    }

    public void setWeight_product(String weight_product) {
        this.weight_product = weight_product;
    }

    public Float getPriceB_product() {
        return priceB_product;
    }

    public void setPriceB_product(Float priceB_product) {
        this.priceB_product = priceB_product;
    }

    public Float getPriceS_product() {
        return priceS_product;
    }

    public void setPriceS_product(Float priceS_product) {
        this.priceS_product = priceS_product;
    }

    public Long getStock_product() {
        return stock_product;
    }

    public void setStock_product(Long stock_product) {
        this.stock_product = stock_product;
    }

    public Pet_type getPet_type() {
        return pet_type;
    }

    public void setPet_type(Pet_type pet_type) {
        this.pet_type = pet_type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
