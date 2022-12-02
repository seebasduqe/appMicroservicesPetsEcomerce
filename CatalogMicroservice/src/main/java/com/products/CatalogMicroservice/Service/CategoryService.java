package com.products.CatalogMicroservice.Service;

import com.products.CatalogMicroservice.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    public Page<Category> getAll(Pageable pageable);
    public Category getById(Long id);
    public Category saveCategory(Category category);
    public Category updateCategory(Category category, Long id);
    public void deleteCategory(Long id);

}
