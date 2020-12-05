package com.diy.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.OrderCreateRequest;
import com.diy.shop.dto.OrderWarrantyRequest;

public interface OrderService {

    JSONObject createOrder(String userUid, OrderCreateRequest request);

    JSONObject orders(String userUid);

    JSONObject specOrder(String userUid, String orderUid);

    JSONObject useWarranty(String orderUid, OrderWarrantyRequest request);

    JSONObject delOrder(String orderUid);
}
