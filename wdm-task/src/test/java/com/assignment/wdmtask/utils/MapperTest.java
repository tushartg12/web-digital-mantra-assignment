package com.assignment.wdmtask.utils;

import com.assignment.wdmtask.DTO.ProductDto;
import com.assignment.wdmtask.Entity.Product;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MapperTest {
    @Mock
    ModelMapper modelMapper;
    @InjectMocks TestUtils testUtils;
    @InjectMocks Mapper mapper;

    @Test
    @Description("Happy Path for converting ProductDto to Product")
    void dtoToProduct() {
        when(modelMapper.map(testUtils.getProductDto(), Product.class)).thenReturn(testUtils.getProduct());
        assertEquals(testUtils.getProduct(),mapper.dtoToProduct(testUtils.getProductDto()));
        verify(modelMapper).map(testUtils.getProductDto(), Product.class);
    }

    @Test
    @Description("Happy Path for converting Product to ProductDto")
    void productToDto() {
        when(modelMapper.map(testUtils.getProduct(), ProductDto.class)).thenReturn(testUtils.getProductDto());
        assertEquals(testUtils.getProductDto(),mapper.productToDto(testUtils.getProduct()));
        verify(modelMapper).map(testUtils.getProduct(), ProductDto.class);
    }
}