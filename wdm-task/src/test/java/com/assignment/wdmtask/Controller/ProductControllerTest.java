package com.assignment.wdmtask.Controller;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Service.ProductService;
import com.assignment.wdmtask.utils.ApiResponse;
import com.assignment.wdmtask.utils.TestUtils;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    ProductService productService;
    @InjectMocks
    TestUtils testUtils;
    @InjectMocks
    ProductController productController;

    @Test
    @Description("Happy Path for Add Product API")
    void addProduct_Test1() {
        when(productService.createProduct(testUtils.getProductDto())).thenReturn(testUtils.getProductDto());
        assertEquals(testUtils.getProductDto(),productController.addProduct(testUtils.getProductDto()).getBody());
        assertEquals(HttpStatus.CREATED,productController.addProduct(testUtils.getProductDto()).getStatusCode());
        verify(productService,times(2)).createProduct(testUtils.getProductDto());
    }

    @Test
    @Description("Happy Path for getting all products API")
    void getAllProducts_Test1() {
        when(productService.getAllProducts()).thenReturn(List.of(testUtils.getProductDto()));
        assertEquals(List.of(testUtils.getProductDto()),productController.getAllProducts().getBody());
        assertEquals(HttpStatus.OK,productController.getAllProducts().getStatusCode());
        verify(productService,times(2)).getAllProducts();
    }

    @Test
    @Description("Happy path for get product by id API")
    void getProductById_Test1() {
        int productId=1;
        when(productService.getProductById(productId)).thenReturn(testUtils.getProductDto());
        assertEquals(testUtils.getProductDto(),productController.getProductById(productId).getBody());
        assertEquals(HttpStatus.OK,productController.getProductById(productId).getStatusCode());
        verify(productService,times(2)).getProductById(productId);
    }

    @Test
    @Description("Happy path for update product API")
    void updateProduct_Test1() {
        int productId=1;
        ProductDto updatedProductDto=testUtils.getProductDto();
        updatedProductDto.setPrice(100);
        when(productService.updateProduct(updatedProductDto,productId)).thenReturn(updatedProductDto);
        assertEquals(updatedProductDto,productController.updateProduct(productId,updatedProductDto).getBody());
        assertEquals(HttpStatus.OK,productController.updateProduct(productId,updatedProductDto).getStatusCode());
        verify(productService,times(2)).updateProduct(updatedProductDto,productId);
    }

    @Test
    @Description("Happy path for delete product API")
    void deleteProduct() {
        int productId=1;
        doNothing().when(productService).deleteProduct(productId);
        assertEquals(new ApiResponse("Product deleted successfully",true),productController.deleteProduct(productId).getBody());
        assertEquals(HttpStatus.OK,productController.deleteProduct(productId).getStatusCode());
        verify(productService,times(2)).deleteProduct(productId);
    }
}