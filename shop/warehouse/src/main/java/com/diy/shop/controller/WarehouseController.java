package com.diy.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemRequest;
import com.diy.shop.dto.OrderWarrantyRequest;
import com.diy.shop.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping(value = "/{orderItemUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject getItemInfo(@PathVariable("orderItemUid")String orderItemUid){
        return warehouseService.getItemInfo(orderItemUid);
    }

    @PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject getItem(@RequestBody ItemRequest request){
        return warehouseService.getItem(request);
    }

    @PostMapping(value = "/{orderItemUid}/warranty",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject warranty(@PathVariable("orderItemUid")String orderItemUid,@RequestBody OrderWarrantyRequest request){
        return warehouseService.warranty(orderItemUid,request);
    }

    @DeleteMapping(value = "/{orderItemUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject returnItem(@PathVariable("orderItemUid")String orderItemUid){
        return warehouseService.returnItem(orderItemUid);
    }
}
