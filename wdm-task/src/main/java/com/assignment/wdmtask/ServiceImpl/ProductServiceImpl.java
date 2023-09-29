package com.assignment.wdmtask.ServiceImpl;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Entity.Product;
import com.assignment.wdmtask.Exception.ProductNotFoundException;
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
/*
    For converting DTOs to Entity and vise-versa Mapper is used,
    two functions are created in it.
*/
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product=mapper.dtoToProduct(productDto);
        return mapper.productToDto(productRepository.save(product));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {
        Product product=productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product","id", productId));
        product.setName(productDto.getName());
        product.setAbout(productDto.getAbout());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        return mapper.productToDto(productRepository.save(product));
    }

    @Override
    public ProductDto getProductById(Integer productId) {
        Product product=productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product","id", productId));
        return mapper.productToDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(product -> mapper.productToDto(product)).toList();
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product=productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product","id", productId));
        productRepository.delete(product);
    }
}
