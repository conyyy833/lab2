package com.diy.shop.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
//货物和订单是多对多关系 n:n
public class Items implements Serializable {
    @Id
    @SequenceGenerator(sequenceName="test_sequence", name="abc" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="abc")
    @Column(name="id")
    private Integer id;
    @Column(name = "available_count", nullable = false)
    private Long available_count;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "size", nullable = false)
    private String size;
}
