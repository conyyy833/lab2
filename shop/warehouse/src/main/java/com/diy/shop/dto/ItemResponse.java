package com.diy.shop.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ItemResponse {

    private UUID orderItemUid;

    private UUID orderUid;

    private String model;

    private String size;

}
