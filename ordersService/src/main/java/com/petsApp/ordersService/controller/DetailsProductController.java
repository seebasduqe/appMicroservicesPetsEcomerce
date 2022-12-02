package com.petsApp.ordersService.controller;


import com.petsApp.ordersService.entity.DetailsProduct;
import com.petsApp.ordersService.service.DetailsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details_product")
public class DetailsProductController {

    @Autowired
    DetailsProductService detailsProductService;

    @GetMapping
    public ResponseEntity<List<DetailsProduct>> getAll(){
        List<DetailsProduct> detailsProducts = detailsProductService.getAllDetailsProduct();
        if(detailsProducts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detailsProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsProduct> getById(@PathVariable("id") Long id){
        DetailsProduct detailsProduct = detailsProductService.getByIdDetailsProduct(id);
        if(detailsProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detailsProduct);
    }


    @PostMapping
    public ResponseEntity<DetailsProduct> save(@RequestBody DetailsProduct detailsProduct){
        DetailsProduct detailsProductSaved =detailsProductService.saveDetailsProduct(detailsProduct);
        if(detailsProductSaved == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(detailsProductSaved);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DetailsProduct> update(@PathVariable("id") Long id,@RequestBody DetailsProduct detailsProduct){
        DetailsProduct detailsProductUpdated = detailsProductService.updateDetailsProduct(detailsProduct, id);
        if(detailsProductUpdated == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(detailsProductUpdated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<DetailsProduct> delete(@PathVariable("id") Long id){
        DetailsProduct detailsProductDeleted = detailsProductService.getByIdDetailsProduct(id);
        if(detailsProductDeleted == null){
            return ResponseEntity.notFound().build();
        }
        detailsProductService.deleteDetailsProduct(id);
        return ResponseEntity.ok(detailsProductDeleted);
    }

}
