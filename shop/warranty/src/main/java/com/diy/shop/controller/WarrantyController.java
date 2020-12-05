package com.diy.shop.controller;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemWarrantyRequest;
import com.diy.shop.service.WarrantyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/warranty")
public class WarrantyController {
    @Autowired
    private WarrantyService warrantyService;

    @PostMapping(value = "/{itemUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject startWarranty(@PathVariable("itemUid") String itemUid){
        return warrantyService.startWarranty(itemUid);
    }

    @GetMapping(value ="/{itemUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject getWarranty(@PathVariable("itemUid") String itemUid){
        return warrantyService.getWarranty(itemUid);
    }

    @PostMapping(value ="/{itemUid}/warranty",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject warrantyRequest(@PathVariable("itemUid") String itemUid, @RequestBody ItemWarrantyRequest request){
        return warrantyService.warrantyRequest(itemUid, request);
    }

    @DeleteMapping(value ="/{itemUid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject stopWarranty(@PathVariable("itemUid") String itemUid) {
        return warrantyService.stopWarranty(itemUid);
    }
}
