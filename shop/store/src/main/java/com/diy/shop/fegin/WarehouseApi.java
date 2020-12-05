package com.diy.shop.fegin;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("warehouse")
public interface WarehouseApi {

    @RequestMapping(value = "/api/v1/warehouse",method = RequestMethod.POST)
    JSONObject getItem(ItemRequest request);
}
