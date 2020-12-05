package com.diy.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.OrderCreateRequest;
import com.diy.shop.dto.OrderWarrantyRequest;
import com.diy.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value="/{userUid}/purchase",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject createOrder(@PathVariable("userUid") String userUid,@RequestBody OrderCreateRequest request){
        return orderService.createOrder(userUid,request);
    }

    @GetMapping(value="/{userUid}/{orderUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject specOrder(@PathVariable("userUid") String userUid,@PathVariable("orderUid") String orderUid){
        return orderService.specOrder(userUid,orderUid);
    }

    @GetMapping(value="/{userUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject orders(@PathVariable("userUid") String userUid){
        return orderService.orders(userUid);
    }

    @PostMapping(value="/{orderUid}/warranty",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject useWarranty(@PathVariable("orderUid") String orderUid,@RequestBody OrderWarrantyRequest request){
        return orderService.useWarranty(orderUid,request);
    }

    @DeleteMapping(value="/{orderUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject delOrder(@PathVariable("orderUid") String orderUid){
        return orderService.delOrder(orderUid);
    }
}
