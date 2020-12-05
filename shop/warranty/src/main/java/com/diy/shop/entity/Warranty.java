package com.diy.shop.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warranty")
//货物和订单是多对多关系 n:n
public class Warranty implements Serializable {
    @Id
    @SequenceGenerator(sequenceName="test_sequence", name="abc" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="abc")
    @Column(name="id")
    private Integer id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "item_uid", nullable = false)
    private UUID itemUid;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "warranty_date", nullable = false)
    private Date warranty_date;
}
