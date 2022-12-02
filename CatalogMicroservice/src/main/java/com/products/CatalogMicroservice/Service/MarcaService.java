package com.products.CatalogMicroservice.Service;

import com.products.CatalogMicroservice.Entity.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MarcaService {

    public Page<Marca> getAll(Pageable page);
    public Marca getById(Long id);
    public Marca saveMarca(Marca marca);
    public Marca updateMarca(Marca marca, Long id);
    public void deleteMarca(Long id);
}
