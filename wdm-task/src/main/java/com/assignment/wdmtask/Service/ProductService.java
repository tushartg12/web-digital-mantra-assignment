package com.assignment.wdmtask.Service;

import com.assignment.wdmtask.DTO.ProductDto;
import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, Integer productId);
    ProductDto getProductById(Integer productId);
    List<ProductDto> getAllProducts();
    void deleteProduct(Integer productId);
}
