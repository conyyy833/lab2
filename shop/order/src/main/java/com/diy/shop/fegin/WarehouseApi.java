package com.diy.shop.fegin;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemRequest;
import com.diy.shop.dto.OrderWarrantyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("warehouse")
public interface WarehouseApi {

    @PostMapping(value = "/api/v1/warehouse",produces = MediaType.APPLICATION_JSON_VALUE)
    JSONObject getItem(@RequestBody ItemRequest request);

    @PostMapping("/api/v1/warehouse/{orderItemUid}/warranty")
    JSONObject warrantyRequest(@RequestParam("orderItemUid") String orderItemUid, @RequestBody OrderWarrantyRequest request);
}
