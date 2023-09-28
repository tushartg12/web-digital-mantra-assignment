package com.assignment.wdmtask.utils;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Entity.Product;
import com.assignment.wdmtask.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    ModelMapper modelMapper;
    public Product dtoToProduct(ProductDto productDto){
        return modelMapper.map(productDto, Product.class);
    }
    public ProductDto productToDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }
}
