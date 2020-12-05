package com.diy.shop.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemRequest {
    private String model;
    private String size;
    private UUID orderUid;
}
