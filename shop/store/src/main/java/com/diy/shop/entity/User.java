package com.diy.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    //订单号
    @Id
    @SequenceGenerator(sequenceName="test_sequence", name="abc" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="abc")
    @Column(name="id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_uid")
    private UUID userUid;
}
