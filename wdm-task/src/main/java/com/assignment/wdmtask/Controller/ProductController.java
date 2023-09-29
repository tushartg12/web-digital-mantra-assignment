package com.assignment.wdmtask.Controller;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Service.ProductService;
import com.assignment.wdmtask.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    //POST -> Add Product
    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto productDto){
        ProductDto productDto1=productService.createProduct(productDto);
        return new ResponseEntity<>(productDto1, HttpStatus.CREATED);
    }

    //GET -> Get all products
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDto =productService.getAllProducts();
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    //GET -> Get product by product id
    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable ("productId") Integer productId){
        ProductDto productDto=productService.getProductById(productId);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    //PUT -> Update product
    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable ("productId") Integer productId, @RequestBody @Valid ProductDto productDto){
        ProductDto productDto1=productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(productDto1,HttpStatus.OK);
    }

    //DELETE -> Delete product
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(new ApiResponse("Product deleted successfully",true),HttpStatus.OK);
    }
}
