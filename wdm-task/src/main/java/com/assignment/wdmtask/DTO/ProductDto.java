package com.assignment.wdmtask.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductDto {
    private int id;
    @NotEmpty
    @Size(min=4,message = "Product name must be min of 4 characters")
    private String name;
    @NotEmpty
    @Size(min = 10, message = "Product description must be min of 10 characters")
    private String about;
    @Positive(message = "Prize must be more than Zero")
    private double price;
    @Positive(message = "Quantity must be more than Zero")
    private int quantity;
}
