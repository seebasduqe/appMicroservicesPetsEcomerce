package com.products.CatalogMicroservice.Service;

import com.products.CatalogMicroservice.Entity.Pet_type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Pet_typeService {

    public Page<Pet_type> getAll(Pageable pageable);
    public Pet_type getById(Long id);
    public Pet_type savePet_type(Pet_type pet_type);
    public Pet_type updatePet_type(Pet_type pet_type, Long id);
    public void deletePet_type(Long id);
}
