package com.products.CatalogMicroservice.Service.ImplementService;

import com.products.CatalogMicroservice.Entity.Category;
import com.products.CatalogMicroservice.Repository.CategoryRepository;
import com.products.CatalogMicroservice.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty()){
            return null;
        }

        category.setId(categoryOptional.get().getId());

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
