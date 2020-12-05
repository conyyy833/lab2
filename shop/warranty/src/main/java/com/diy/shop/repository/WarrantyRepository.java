package com.diy.shop.repository;

import com.diy.shop.entity.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

    Warranty findWarrantyByItemUid(UUID itemUid);

}
