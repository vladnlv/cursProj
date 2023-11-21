package com.example.appp.dto;

import com.example.appp.entity.Product;
import com.example.appp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Data
@AllArgsConstructor
public class CartDto {

    private User user;

    private Product product;

    private int quantity;
}
