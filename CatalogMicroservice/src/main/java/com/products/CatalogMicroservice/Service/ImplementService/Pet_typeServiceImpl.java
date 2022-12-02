package com.products.CatalogMicroservice.Service.ImplementService;

import com.products.CatalogMicroservice.Entity.Pet_type;
import com.products.CatalogMicroservice.Repository.Pet_typeRepository;
import com.products.CatalogMicroservice.Service.Pet_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Pet_typeServiceImpl implements Pet_typeService {

    @Autowired
    Pet_typeRepository pet_typeRepository;

    @Override
    public Page<Pet_type> getAll(Pageable pageable) {
        return pet_typeRepository.findAll(pageable);
    }

    @Override
    public Pet_type getById(Long id) {
        return pet_typeRepository.findById(id).orElse(null);
    }

    @Override
    public Pet_type savePet_type(Pet_type pet_type) {
        return pet_typeRepository.save(pet_type);
    }

    @Override
    public Pet_type updatePet_type(Pet_type pet_type, Long id) {
        Optional<Pet_type> pet_typeOptional = pet_typeRepository.findById(id);
        if(pet_typeOptional.isEmpty()){
            return null;
        }
        return pet_typeRepository.save(pet_type);
    }

    @Override
    public void deletePet_type(Long id) {
        pet_typeRepository.deleteById(id);
    }
}