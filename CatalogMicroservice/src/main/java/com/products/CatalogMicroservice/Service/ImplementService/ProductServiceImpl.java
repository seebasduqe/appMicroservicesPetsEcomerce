package com.products.CatalogMicroservice.Service.ImplementService;

import com.products.CatalogMicroservice.Entity.Product;
import com.products.CatalogMicroservice.Repository.ProductRepository;
import com.products.CatalogMicroservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            return null;
        }

        product.setId(productOptional.get().getId());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
