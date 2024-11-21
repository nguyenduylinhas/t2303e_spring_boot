package org.aptech.pring.t2303e_spring.models.response;

import lombok.Getter;
import org.aptech.pring.t2303e_spring.entity.Category;

@Getter
public class CategoryReponse {
    private Long id;
    private String name;
    private String slug;

    private CategoryReponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.slug = category.getSlug();

    }
    public static CategoryReponse getCategory(Category category) {
        return new CategoryReponse(category);
    }

}
