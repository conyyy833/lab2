package com.diy.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @SequenceGenerator(sequenceName="test_sequence", name="abc" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="abc")
    @Column(name="id")
    private Integer id;
    @Column(name = "canceled")
    private Boolean canceled;
    @Column(name = "order_item_uid")
    private UUID orderItemUid;
    @Column(name = "order_uid")
    private UUID orderUid;
    @Column(name="item_id")
    private Integer item_id;
    @Transient
    private Items items;
}
