package com.diy.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.PurchaseRequest;
import com.diy.shop.dto.WarrantyRequest;

public interface StoreService {

    JSONObject createOrder(String userUid, PurchaseRequest request);

    JSONObject orders(String userUid);

    JSONObject specOrder(String userUid, String orderUid);

    JSONObject warranty(String userUid, String orderUid, WarrantyRequest request);

    JSONObject refund(String userUid, String orderUid);
}
