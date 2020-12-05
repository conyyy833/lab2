package com.diy.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemRequest;
import com.diy.shop.dto.ItemResponse;
import com.diy.shop.dto.ItemWarrantyRequest;
import com.diy.shop.dto.OrderWarrantyRequest;
import com.diy.shop.entity.Items;
import com.diy.shop.entity.OrderItem;
import com.diy.shop.fegin.WarrantyApi;
import com.diy.shop.repository.OrderItemRepository;
import com.diy.shop.repository.WarehouseRepository;
import com.diy.shop.service.BaseService;
import com.diy.shop.service.WarehouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class WarehouseServiceImpl extends BaseService implements WarehouseService {
    @Resource
    private WarehouseRepository warehouseRepository;
    @Resource
    private OrderItemRepository orderItemRepository;
    @Resource
    private WarrantyApi warrantyApi;

    @Override
    public JSONObject getItem(ItemRequest request) {
        Items items = warehouseRepository.findItemsByModelEqualsAndSizeEquals(request.getModel(), request.getSize());
        UUID orderItemUid = UUID.randomUUID();
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemUid(orderItemUid);
        orderItem.setCanceled(false);
        orderItem.setItem_id(items.getId());
        orderItem.setOrderUid(request.getOrderUid());
        orderItem  = orderItemRepository.save(orderItem);
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setOrderItemUid(orderItem.getOrderItemUid());
        itemResponse.setOrderUid(orderItem.getOrderUid());
        itemResponse.setModel(items.getModel());
        itemResponse.setSize(items.getSize());
        return responseOk("查询成功",itemResponse);
    }

    @Override
    public JSONObject getItemInfo(String orderItemUid) {
        OrderItem orderItem = orderItemRepository.findOrderItemByOrderItemUid(UUID.fromString(orderItemUid));
        Integer item_id = orderItem.getItem_id();
        Items items = warehouseRepository.findItemsById(item_id);
        orderItem.setItems(items);
        return responseOk("查询成功",orderItem);
    }

    @Override
    public JSONObject warranty(String orderItemUid, OrderWarrantyRequest request) {
        OrderItem orderItem = orderItemRepository.findOrderItemByOrderItemUid(UUID.fromString(orderItemUid));
        ItemWarrantyRequest itemWarrantyRequest = new ItemWarrantyRequest();
        itemWarrantyRequest.setReason(request.getReason());
        Integer item_id = orderItem.getItem_id();
        Items items = warehouseRepository.findItemsById(item_id);
        itemWarrantyRequest.setAvailableCount(items.getAvailable_count().intValue());
        return warrantyApi.warrantyRequest(orderItemUid,itemWarrantyRequest);
    }

    @Override
    public JSONObject returnItem(String orderItemUid) {
        OrderItem orderItem = orderItemRepository.findOrderItemByOrderItemUid(UUID.fromString(orderItemUid));
        orderItem.setCanceled(true);
        orderItemRepository.save(orderItem);
        return responseOk("操作成功",orderItem);
    }
}
