package com.diy.shop.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.PurchaseRequest;
import com.diy.shop.dto.WarrantyRequest;
import com.diy.shop.entity.User;
import com.diy.shop.fegin.OrderApi;
import com.diy.shop.fegin.WarehouseApi;
import com.diy.shop.fegin.WarrantyApi;
import com.diy.shop.repository.UserRepository;
import com.diy.shop.service.BaseService;
import com.diy.shop.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class StoreServiceImpl extends BaseService implements StoreService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WarehouseApi warehouseApi;
    @Autowired
    private WarrantyApi warrantyApi;
    @Autowired
    OrderApi orderApi;

    @Override
    public JSONObject createOrder(String userUid, PurchaseRequest request) {
        JSONObject order = orderApi.createOrder(userUid, request);
        return order;
    }

    @Override
    public JSONObject orders(String userUid) {
        JSONObject orders = orderApi.orders(userUid);
        return orders;
    }

    @Override
    public JSONObject specOrder(String userUid, String orderUid) {
        return orderApi.specOrder(userUid,orderUid);
    }

    @Override
    public JSONObject warranty(String userUid, String orderUid, WarrantyRequest request) {
        User user = userRepository.findUserByUserUid(UUID.fromString(userUid));
        if(user==null){
            return responseFail("用户不存在");
        }
        return orderApi.warranty(orderUid,request);
    }

    @Override
    public JSONObject refund(String userUid, String orderUid) {
        return orderApi.specOrder(userUid,orderUid);
    }
}
