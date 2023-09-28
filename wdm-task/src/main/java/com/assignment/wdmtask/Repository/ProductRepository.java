package com.assignment.wdmtask.Repository;

import com.assignment.wdmtask.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
