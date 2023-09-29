package com.assignment.wdmtask.ServiceImpl;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Entity.Product;
import com.assignment.wdmtask.Exception.ProductNotFoundException;
import com.assignment.wdmtask.Repository.ProductRepository;
import com.assignment.wdmtask.utils.Mapper;
import com.assignment.wdmtask.utils.TestUtils;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    Mapper mapper;
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    TestUtils testUtils;
    @InjectMocks ProductServiceImpl productService;
    @Test
    @Description("Happy Path for saving a Product")
    void createProduct_Test1() {
        when(mapper.dtoToProduct(testUtils.getProductDto())).thenReturn(testUtils.getProduct());
        when(productRepository.save(testUtils.getProduct())).thenReturn(testUtils.getProduct());
        when(mapper.productToDto(productRepository.save(testUtils.getProduct()))).thenReturn(testUtils.getProductDto());
        assertEquals(testUtils.getProductDto(),productService.createProduct(testUtils.getProductDto()));
        verify(mapper).dtoToProduct(testUtils.getProductDto());
        verify(mapper).productToDto(testUtils.getProduct());
        verify(productRepository,times(2)).save(testUtils.getProduct());
    }

    @Test
    @Description("Happy path for updating the Product")
    void updateProduct_Test1() {
        int productId=1;
        ProductDto updatedProductDto=testUtils.getProductDto();
        updatedProductDto.setPrice(100);
        Product product=testUtils.getProduct();
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        when(mapper.productToDto(productRepository.save(product))
        ).thenReturn(updatedProductDto);
        assertEquals(updatedProductDto,productService.updateProduct(updatedProductDto,productId));
        verify(productRepository,times(2)).save(product);
        verify(productRepository).findById(productId);
        verify(mapper).productToDto(productRepository.save(product));
    }
    @Test
    @Description("Exception Case: Product Not Found")
    void updateProduct_Test2() {
        int productId=1;
        ProductDto updatedProductDto=testUtils.getProductDto();
        updatedProductDto.setPrice(100);
        when(productRepository.findById(productId)).thenThrow(new ProductNotFoundException("Product", "id",1));
        ProductNotFoundException productNotFoundException=assertThrows(ProductNotFoundException.class,()->productService.updateProduct(updatedProductDto,productId));
        assertEquals("Product not found with id : 1",productNotFoundException.getMessage());
        verify(productRepository).findById(productId);
    }
    @Test
    @Description("Happy Path for getting product by Id")
    void getProductById_Test1() {
        int productId=1;
        when(productRepository.findById(productId)).thenReturn(Optional.of(testUtils.getProduct()));
        when(mapper.productToDto(testUtils.getProduct())).thenReturn(testUtils.getProductDto());
        assertEquals(testUtils.getProductDto(),productService.getProductById(productId));
        verify(productRepository).findById(productId);
        verify(mapper).productToDto(testUtils.getProduct());
    }

    @Test
    @Description("Exception Case: Product Not Found")
    void getProductById_Test2() {
        int productId=1;
        when(productRepository.findById(productId)).thenThrow(new ProductNotFoundException("Product", "id",1));
        ProductNotFoundException productNotFoundException=assertThrows(ProductNotFoundException.class,()->productService.getProductById(productId));
        assertEquals("Product not found with id : 1",productNotFoundException.getMessage());
        verify(productRepository).findById(productId);
    }

    @Test
    @Description("Happy path for getting all Products")
    void getAllProducts_Test1() {
        when(productRepository.findAll()).thenReturn(List.of(testUtils.getProduct()));
        when(mapper.productToDto(testUtils.getProduct())).thenReturn(testUtils.getProductDto());
        assertEquals(List.of(testUtils.getProductDto()),productService.getAllProducts());
        verify(productRepository).findAll();
        verify(mapper).productToDto(testUtils.getProduct());
    }

    @Test
    @Description("Happy path for deleting the product")
    void deleteProduct_Test1() {
        int productId=1;
        when(productRepository.findById(productId)).thenReturn(Optional.of(testUtils.getProduct()));
        assertDoesNotThrow(()->productService.deleteProduct(productId));
        verify(productRepository).findById(productId);
    }
    @Test
    @Description("Exception Case: Product Not Found")
    void deleteProduct_Test2() {
        int productId=1;
        when(productRepository.findById(productId)).thenThrow(new ProductNotFoundException("Product", "id",1));
        ProductNotFoundException productNotFoundException=assertThrows(ProductNotFoundException.class,()->productService.deleteProduct(productId));
        assertEquals("Product not found with id : 1",productNotFoundException.getMessage());
        verify(productRepository).findById(productId);
    }
}