package com.products.CatalogMicroservice.Controller;

import com.products.CatalogMicroservice.Entity.Product;
import com.products.CatalogMicroservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();

        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id){
        Product productById = productService.getById(id);
        if(productById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productById);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        Product productSave = productService.saveProduct(product);
        if(productSave == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(productSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable("id") Long id){
        Product productUpdate = productService.updateProduct(product, id);
        return ResponseEntity.ok(productUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id){
        Product productDelete = productService.getById(id);
        if(productDelete == null){
            return ResponseEntity.notFound().build();
        }
        productService.deleteProduct(id);
        return ResponseEntity.ok(productDelete);
    }
}
