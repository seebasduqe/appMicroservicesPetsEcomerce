package com.petsApp.ordersService.service;


import com.petsApp.ordersService.entity.DetailsProduct;
import com.petsApp.ordersService.repository.DetailsProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailsProductService {

    @Autowired
    DetailsProductRepository detailsProductRepository;


    public List<DetailsProduct> getAllDetailsProduct() {
        return detailsProductRepository.findAll();
    }

    public DetailsProduct getByIdDetailsProduct(Long id) {
        return detailsProductRepository.findById(id).orElse(null);
    }

    public DetailsProduct saveDetailsProduct(DetailsProduct detailsProduct) {
        return detailsProductRepository.save(detailsProduct);
    }

    public DetailsProduct updateDetailsProduct(DetailsProduct detailsProduct, Long id) {
        Optional<DetailsProduct> detailsProductOptional = detailsProductRepository.findById(id);
        if(detailsProductOptional.isEmpty()){
            return null;
        }
        detailsProduct.setId(detailsProductOptional.get().getId());
        return detailsProductRepository.save(detailsProduct);
    }

    public void deleteDetailsProduct(Long id) {
        detailsProductRepository.deleteById(id);
    }

}
