package org.aptech.pring.t2303e_spring.controller;

import org.aptech.pring.t2303e_spring.entity.Product;
import org.aptech.pring.t2303e_spring.models.response.CategoryReponse;
import org.aptech.pring.t2303e_spring.models.response.ProductResponse;
import org.aptech.pring.t2303e_spring.request.CategoryRequest;
import org.aptech.pring.t2303e_spring.request.ProductRequest;
import org.aptech.pring.t2303e_spring.service.CategoryService;
import org.aptech.pring.t2303e_spring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService    ;
    }
    @GetMapping()
    public List<CategoryReponse> getAllCategory() {
        return categoryService.getAll();
    }
    @PostMapping()
    public CategoryReponse createCategory(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.createCategory(categoryRequest);
    }
    @PutMapping("/{id}")
    public CategoryReponse updateCategory(@PathVariable Long id, @RequestBody CategoryRequest req){
        return categoryService.updateCategory(id,req);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
