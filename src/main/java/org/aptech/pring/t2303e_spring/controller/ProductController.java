package org.aptech.pring.t2303e_spring.controller;

import org.aptech.pring.t2303e_spring.entity.Product;
import org.aptech.pring.t2303e_spring.models.response.ProductResponse;
import org.aptech.pring.t2303e_spring.request.ProductRequest;
import org.aptech.pring.t2303e_spring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<ProductResponse> getAllProduct(){
        return productService.getAll();
    }
    @PostMapping()
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest req){
        return productService.updateProduct(id,req);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @GetMapping("/search")
    public List<ProductResponse> search(@RequestParam String search){
        return productService.search(search);
    }
    @GetMapping("/filter")
    public List<ProductResponse> filter(@RequestParam String name,
                                        @RequestParam Integer minPrice,
                                        @RequestParam Integer maxPrice){
        return productService.filter(name,minPrice,maxPrice);
    }
}
