package com.products.CatalogMicroservice.Controller;

import com.products.CatalogMicroservice.Entity.Marca;
import com.products.CatalogMicroservice.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping
    public ResponseEntity<Page<Marca>> getAll(Pageable pageable){
        Page<Marca> marcas = marcaService.getAll(pageable);
        if (marcas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getById(@PathVariable("id") Long id){
        Marca marcaById = marcaService.getById(id);
        if (marcaById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(marcaById);
    }

    @PostMapping
    public ResponseEntity<Marca> save(@RequestBody Marca marca){
        Marca marcaSave = marcaService.saveMarca(marca);
        if(marcaSave == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(marcaSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@RequestBody Marca marca, @PathVariable("id") Long id){
        Marca marcaId = marcaService.getById(id);
        if(marcaId == null){
            return ResponseEntity.notFound().build();
        }
        Marca marcaUpdate = marcaService.updateMarca(marca, id);
        return ResponseEntity.ok(marcaUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marca> delete(@PathVariable("id") Long id){
        Marca marcaId = marcaService.getById(id);
        if (marcaId == null){
            return ResponseEntity.notFound().build();
        }
        marcaService.deleteMarca(id);
        return ResponseEntity.ok(marcaId);
    }
}
