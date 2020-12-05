package com.diy.shop.repository;

import com.diy.shop.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Items, Long> {

    Items findItemsByModelEqualsAndSizeEquals(String model,String size);

    Items findItemsById(Integer id);

}
