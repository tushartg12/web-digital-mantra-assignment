package com.assignment.wdmtask.utils;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    ModelMapper modelMapper;
    //For converting DTO to Entity
    public Product dtoToProduct(ProductDto productDto){
        return modelMapper.map(productDto, Product.class);
    }
    //For converting Entity to DTO
    public ProductDto productToDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }
}
