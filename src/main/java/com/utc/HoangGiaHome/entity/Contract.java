package com.utc.HoangGiaHome.entity;

import com.utc.HoangGiaHome.entity.enums.ContractDuration;
import com.utc.HoangGiaHome.entity.enums.ContractStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_id;

    @Column(name = "contract_name", length = 100, nullable = false)
    private String contract_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "contractDuration", length = 50, nullable = false)
    private ContractDuration contractDuration;

    @Column(name = "start_date", nullable = false)
    private Date start_date;

    @Column(name = "end_date", nullable = false)
    private Date end_date;

    @Column(name = "rent_price", length = 50, nullable = false)
    private String rent_price;

    @Column(name = "room_deposit", length = 50, nullable = false)
    private String room_deposit;

    @Enumerated(EnumType.STRING)
    @Column(name = "contractStatus", length = 50, nullable = false)
    private ContractStatus contractStatus;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

}