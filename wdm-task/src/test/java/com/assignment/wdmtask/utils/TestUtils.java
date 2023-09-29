package com.assignment.wdmtask.utils;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Entity.Product;

public class TestUtils {
    public ProductDto getProductDto(){
        ProductDto productDto=new ProductDto();
        productDto.setId(1);
        productDto.setName("Product");
        productDto.setAbout("About");
        productDto.setQuantity(10);
        productDto.setPrice(50);
        return productDto;
    }
    public Product getProduct(){
        Product product=new Product();
        product.setId(1);
        product.setName("Product");
        product.setAbout("About");
        product.setQuantity(10);
        product.setPrice(50);
        return product;
    }
}
