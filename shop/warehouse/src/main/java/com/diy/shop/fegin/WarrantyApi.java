package com.diy.shop.fegin;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemWarrantyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("warranty")
public interface WarrantyApi {

    @RequestMapping(value = "/api/v1/warranty/{itemUid}",method = RequestMethod.POST)
    JSONObject startWarranty(@RequestParam("itemUid") String itemUid);

    @PostMapping("/api/v1/warranty/{itemUid}/warranty")
    public JSONObject warrantyRequest(@RequestParam("itemUid") String itemUid, @RequestBody ItemWarrantyRequest request);
}
