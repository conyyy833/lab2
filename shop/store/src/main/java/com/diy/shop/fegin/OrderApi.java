package com.diy.shop.fegin;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.PurchaseRequest;
import com.diy.shop.dto.WarrantyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("order")
public interface OrderApi {

    @RequestMapping(value = "/api/v1/orders/{userUid}/purchase",method = RequestMethod.POST)
    JSONObject createOrder(@RequestParam("userUid")String userUid,@RequestBody PurchaseRequest request);

    @RequestMapping(value = "/api/v1/orders/{userUid}",method = RequestMethod.GET)
    JSONObject orders(@RequestParam("userUid")String userUid);

    @GetMapping("/api/v1/orders/{userUid}/{orderUid}")
    JSONObject specOrder(@RequestParam("userUid") String userUid,@RequestParam("orderUid") String orderUid);

    @PostMapping("/api/v1/orders/{orderUid}/warranty")
    public JSONObject warranty(@RequestParam("orderUid") String orderUid,@RequestBody WarrantyRequest request);
}
