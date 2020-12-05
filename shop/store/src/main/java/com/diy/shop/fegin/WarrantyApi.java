package com.diy.shop.fegin;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("warranty")
public interface WarrantyApi {

    @RequestMapping(value = "/api/v1/warranty/{itemUid}/warranty",method = RequestMethod.POST)
    JSONObject startWarranty(@RequestParam("itemUid") String itemUid);

}
