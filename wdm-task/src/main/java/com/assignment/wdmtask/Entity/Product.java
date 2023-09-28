package com.assignment.wdmtask.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false)
    private int id;
    @Column(name = "product_name", nullable = false, length = 50)
    private String name;
    @Column(name = "product_about",length = 1000)
    private String about;
    @Column(name = "product_price", nullable = false)
    private double price;
    @Column(name = "product_quantity", nullable = false)
    private int quantity;
}
