package com.assignment.wdmtask.ServiceImpl;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Entity.Product;
import com.assignment.wdmtask.Repository.ProductRepository;
import com.assignment.wdmtask.Service.ProductService;
import com.assignment.wdmtask.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Mapper mapper;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product=mapper.dtoToProduct(productDto);
        return mapper.productToDto(productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
        return null;
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(product -> mapper.productToDto(product)).toList();
    }

    @Override
    public void deleteProduct(Integer productId) {

    }
}
