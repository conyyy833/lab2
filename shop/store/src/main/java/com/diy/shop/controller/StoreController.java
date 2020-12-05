package com.diy.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.PurchaseRequest;
import com.diy.shop.dto.WarrantyRequest;
import com.diy.shop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/{userUid}/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject orders(@PathVariable("userUid") String userUid){
        return storeService.orders(userUid);
    }

    @GetMapping(value="/{userUid}/{orderUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject specOrder(@PathVariable("userUid") String userUid,@PathVariable("userUid") String orderUid){
        return storeService.specOrder(userUid,orderUid);
    }

    @PostMapping(value="/{userUid}/{orderUid}/warranty",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject warranty(@PathVariable("userUid") String userUid, @PathVariable("userUid") String orderUid, @RequestBody WarrantyRequest request){
        return storeService.warranty(userUid,orderUid,request);
    }

    @PostMapping(value = "/{userUid}/purchase",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject createOrder(@PathVariable("userUid") String userUid,@RequestBody PurchaseRequest request){
        return storeService.createOrder(userUid,request);
    }

    @PostMapping(value="/{userUid}/{orderUid}/refund",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject refund(@PathVariable("userUid") String userUid, @PathVariable("userUid") String orderUid){
        return storeService.refund(userUid,orderUid);
    }

}
