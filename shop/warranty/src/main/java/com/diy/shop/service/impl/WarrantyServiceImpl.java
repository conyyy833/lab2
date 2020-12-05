package com.diy.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemWarrantyRequest;
import com.diy.shop.entity.Warranty;
import com.diy.shop.repository.WarrantyRepository;
import com.diy.shop.service.BaseService;
import com.diy.shop.service.WarrantyService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class WarrantyServiceImpl extends BaseService implements WarrantyService {
    @Resource
    private WarrantyRepository warrantyRepository;

    @Override
    public JSONObject startWarranty(String itemUid) {
        Warranty warranty = new Warranty();
        warranty.setItemUid(UUID.fromString(itemUid));
        warranty.setStatus("ON_WARRANTY");
        warranty.setWarranty_date(new Date());
        warrantyRepository.save(warranty);
        return responseOk();
    }

    @Override
    public JSONObject getWarranty(String itemUid) {
        Warranty warranty = warrantyRepository.findWarrantyByItemUid(UUID.fromString(itemUid));
        return responseOk("SUCCESS",warranty);
    }

    @Override
    public JSONObject warrantyRequest(String itemUid, ItemWarrantyRequest request) {
        Warranty warranty = warrantyRepository.findWarrantyByItemUid(UUID.fromString(itemUid));
        if(warranty==null){
            return responseFail("Warranty not found for itemUid '" +  itemUid + "'");
        }
        String status = "ON_WARRANTY";
        if(warranty.getStatus().equals("ON_WARRANTY")){
            status = request.getAvailableCount()>0?"RETURN":"FIXING";
        }
        warranty.setComment(request.getReason());
        warranty.setStatus(status);
        warrantyRepository.save(warranty);
        return responseOk("操作成功",warranty);
    }

    @Override
    public JSONObject stopWarranty(String itemUid) {
        Warranty warranty = warrantyRepository.findWarrantyByItemUid(UUID.fromString(itemUid));
        warrantyRepository.delete(warranty);
        return responseOk("SUCCESS",null);
    }
}
