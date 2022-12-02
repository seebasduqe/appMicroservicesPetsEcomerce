package com.products.CatalogMicroservice.Service;

import com.products.CatalogMicroservice.Entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();
    public Product getById(Long id);
    public Product saveProduct(Product product);
    public Product updateProduct(Product product, Long id);
    public void deleteProduct(Long id);

}
