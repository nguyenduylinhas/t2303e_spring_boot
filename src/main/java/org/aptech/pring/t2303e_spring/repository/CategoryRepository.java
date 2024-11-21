package org.aptech.pring.t2303e_spring.repository;

import org.aptech.pring.t2303e_spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
