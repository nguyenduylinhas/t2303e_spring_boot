package org.aptech.pring.t2303e_spring.service;

import org.aptech.pring.t2303e_spring.entity.Category;
import org.aptech.pring.t2303e_spring.models.response.CategoryReponse;
import org.aptech.pring.t2303e_spring.repository.CategoryRepository;
import org.aptech.pring.t2303e_spring.request.CategoryRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryReponse> getAll(){
        List<CategoryReponse> data = new ArrayList<>();
        categoryRepository.findAll().
                forEach(c->data.add(CategoryReponse.getCategory(c)));
        return data;
    }
    public CategoryReponse createCategory(CategoryRequest data){
        Category category = new Category();
        category.setName(data.getName());
        category.setSlug(data.getSlug());
        return CategoryReponse.getCategory(
                categoryRepository.save(category)
        );
    }
    public CategoryReponse updateCategory(Long id,CategoryRequest data){
        return CategoryReponse.getCategory(
                categoryRepository.findById(id)
                        .map(c->{
                            c.setName(data.getName());
                            c.setSlug(data.getSlug());
                            return categoryRepository.save(c);
                        }).orElseGet(()->{
                            Category c = new Category();
                            c.setId(id);
                            c.setName(data.getName());
                            c.setSlug(data.getSlug());
                            return categoryRepository.save(c);
                        })
        );
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}

