package com.assignment.wdmtask.DTO;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private String about;
    private double price;
    private int quantity;
}
