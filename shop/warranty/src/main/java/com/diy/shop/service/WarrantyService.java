package com.diy.shop.service;


import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemWarrantyRequest;

public interface WarrantyService {

    JSONObject startWarranty(String itemUid);

    JSONObject getWarranty(String itemUid);

    JSONObject warrantyRequest(String itemUid, ItemWarrantyRequest request);

    JSONObject stopWarranty(String itemUid);
}
