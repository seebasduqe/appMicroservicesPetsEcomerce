package com.products.CatalogMicroservice.Service.ImplementService;

import com.products.CatalogMicroservice.Entity.Marca;
import com.products.CatalogMicroservice.Repository.MarcaRepository;
import com.products.CatalogMicroservice.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public Page<Marca> getAll(Pageable pageable) {
        return marcaRepository.findAll(pageable);
    }

    @Override
    public Marca getById(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    @Override
    public Marca saveMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca updateMarca(Marca marca, Long id) {
        Optional<Marca> marcaOptional = marcaRepository.findById(id);
        if(marcaOptional.isEmpty()){
            return null;
        }

        marca.setId(marcaOptional.get().getId());
        return marcaRepository.save(marca);
    }

    @Override
    public void deleteMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
