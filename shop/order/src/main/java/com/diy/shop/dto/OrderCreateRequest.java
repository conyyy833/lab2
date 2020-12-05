package com.diy.shop.dto;

import lombok.Data;

@Data
public class OrderCreateRequest {
    private String model;
    private String size;
}
