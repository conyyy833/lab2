package com.diy.shop.repository;

import com.diy.shop.entity.OrderItem;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    OrderItem findOrderItemByOrderItemUid(UUID orderItemUid);
}
