package com.diy.shop.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.diy.shop.dto.ItemRequest;
import com.diy.shop.dto.ItemResponse;
import com.diy.shop.dto.OrderCreateRequest;
import com.diy.shop.dto.OrderWarrantyRequest;
import com.diy.shop.entity.Orders;
import com.diy.shop.fegin.WarehouseApi;
import com.diy.shop.fegin.WarrantyApi;
import com.diy.shop.repository.OrderRepository;
import com.diy.shop.service.BaseService;
import com.diy.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl extends BaseService implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WarehouseApi warehouseApi;
    @Autowired
    private WarrantyApi warrantyApi;

    @Override
    public JSONObject createOrder(String userUid, OrderCreateRequest request) {
        ItemRequest itemRequest = new ItemRequest();
        UUID orderUid = UUID.randomUUID();
        itemRequest.setOrderUid(orderUid);
        itemRequest.setModel(request.getModel());
        itemRequest.setSize(request.getSize());
        JSONObject item = warehouseApi.getItem(itemRequest);
        ItemResponse response = item.getObject("data", ItemResponse.class);
        Orders orders = new Orders();
        orders.setOrderUid(orderUid);
        orders.setItemUid(response.getOrderItemUid());
        UUID uuid = UUID.fromString(userUid);
        orders.setUserUid(uuid);
        orders.setStatus("PAID");
        orders.setOrderDate(new Date());
        JSONObject jsonObject = warrantyApi.startWarranty(response.getOrderItemUid().toString());
        log.info("startWarranty 返回:"+jsonObject.toJSONString());
        Orders order = orderRepository.save(orders);
        return responseOk("下单成功",order);
    }

    @Override
    public JSONObject specOrder(String userUid,String orderUid) {
        Orders orders = orderRepository.findOrdersByUserUidAndAndOrderUid(UUID.fromString(userUid),UUID.fromString(orderUid));
        return responseOk("查询成功",orders);
    }

    @Override
    public JSONObject useWarranty(String orderUid, OrderWarrantyRequest request) {
        Orders orders = orderRepository.findOrdersByOrderUid(UUID.fromString(orderUid));
        JSONObject jsonObject = warehouseApi.warrantyRequest(orders.getItemUid().toString(), request);
        return jsonObject;
    }

    @Override
    public JSONObject delOrder(String orderUid) {
        Orders orders = orderRepository.findOrdersByOrderUid(UUID.fromString(orderUid));
        orders.setStatus("CANCELED");
        orderRepository.save(orders);
        return responseOk("操作成功",null);
    }

    @Override
    public JSONObject orders(String userUid) {
        List<Orders> orders = orderRepository.findAllByUserUid(UUID.fromString(userUid));
        return responseOk("查询成功",orders);
    }
}
