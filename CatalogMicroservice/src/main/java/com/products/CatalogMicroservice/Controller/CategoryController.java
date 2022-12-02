package com.products.CatalogMicroservice.Controller;

import com.products.CatalogMicroservice.Entity.Category;
import com.products.CatalogMicroservice.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> getAll(Pageable pageable){
        Page<Category> categories = categoryService.getAll(pageable);
        if(categories.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Long id){
        Category categoryById = categoryService.getById(id);
        if (categoryById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryById);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category){
        Category categorySave = categoryService.saveCategory(category);
        if(categorySave == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(categorySave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable("id") Long id){
        Category categoryId = categoryService.getById(id);
        if (categoryId == null){
            return ResponseEntity.noContent().build();
        }
        Category categoryUpdate = categoryService.updateCategory(category, id);
        return ResponseEntity.ok(categoryUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") Long id){
        Category categoryDelete = categoryService.getById(id);
        if (categoryDelete == null){
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(categoryDelete);
    }
}
