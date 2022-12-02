package com.products.CatalogMicroservice.Controller;

import com.products.CatalogMicroservice.Entity.Pet_type;
import com.products.CatalogMicroservice.Service.Pet_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet_type")
public class Pet_typeController {

    @Autowired
    Pet_typeService pet_typeService;

    @GetMapping
    public ResponseEntity<Page<Pet_type>> getAll(Pageable pageable){
        Page<Pet_type> pet_types = pet_typeService.getAll(pageable);
        if(pet_types.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pet_types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet_type> getById(@PathVariable("id") Long id){
        Pet_type pet_typeById = pet_typeService.getById(id);
        if(pet_typeById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pet_typeById);
    }

    @PostMapping
    public ResponseEntity<Pet_type> save(@RequestBody Pet_type pet_type) {
        Pet_type pet_typeSave = pet_typeService.savePet_type(pet_type);
        return ResponseEntity.ok(pet_typeSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet_type> update(@RequestBody Pet_type pet_type,@PathVariable("id") Long id){
        Pet_type pet_typeUpdate = pet_typeService.updatePet_type(pet_type, id);
        if (pet_typeUpdate == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pet_typeUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet_type> delete(@PathVariable("id") Long id){
        Pet_type pet_typeDelete = pet_typeService.getById(id);
        if(pet_typeDelete == null){
            return ResponseEntity.notFound().build();
        }
        pet_typeService.deletePet_type(id);
        return ResponseEntity.ok(pet_typeDelete);
    }

}