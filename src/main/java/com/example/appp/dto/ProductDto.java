package com.example.appp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class ProductDto {

    private Integer productID;

    private String productName;

    private BigDecimal price;

    private String category;

    private Integer count;

}
