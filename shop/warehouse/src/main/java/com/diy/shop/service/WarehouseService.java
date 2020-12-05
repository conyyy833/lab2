package com.diy.shop.service;


import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemRequest;
import com.diy.shop.dto.OrderWarrantyRequest;

public interface WarehouseService {

    JSONObject getItem(ItemRequest request);

    JSONObject getItemInfo(String orderItemUid);

    JSONObject warranty(String orderItemUid, OrderWarrantyRequest request);

    JSONObject returnItem(String orderItemUid);
}
