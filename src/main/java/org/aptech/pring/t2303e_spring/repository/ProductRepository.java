package org.aptech.pring.t2303e_spring.repository;

import org.aptech.pring.t2303e_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
List<Product> findAllByNameAndPrice(String name, Long price);
List<Product> findAllByNameContainingOrDescriptionContaining(String name, String description);
@Query("SELECT p FROM Product p WHERE "+
        "(:name is NULL p.name LIKE %:name%) "+
        "AND (:minPrice is Null or p.price >= :minPrice)"+
        "AND (:maxPrice is Null or p.price <= :maxPrice)"
            )
List<Product> filterProducts(@Param("name")String name,
                             @Param("minPrice") Integer minPrice,
                             @Param("maxPrice")Integer maxPrice);

}
