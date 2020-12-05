package com.diy.shop.repository;

import com.diy.shop.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findAllByUserUid(UUID userUid);

    Orders findOrdersByUserUidAndAndOrderUid(UUID userUid, UUID orderUid);

    Orders findOrdersByOrderUid(UUID orderUid);

}
