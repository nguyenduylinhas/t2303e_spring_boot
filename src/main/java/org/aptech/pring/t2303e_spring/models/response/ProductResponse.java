package org.aptech.pring.t2303e_spring.models.response;

import lombok.Getter;
import org.aptech.pring.t2303e_spring.entity.Product;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private Long price;
    private Boolean inStock;
    private String description;

    private ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.inStock = product.getQty()>0;
        this.description = product.getDescription();
    }
    public static ProductResponse getProduct(Product product) {
        return new ProductResponse(product);
    }

}
