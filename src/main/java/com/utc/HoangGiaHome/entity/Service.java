package com.utc.HoangGiaHome.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

    @Column(name = "service_name", length = 100, nullable = false)
    private String serviceName;

    @Column(name = "price", length = 50, nullable = false)
    private String price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit", length = 50, nullable = false)
    private String unit;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToMany(mappedBy = "service")
    private List<CustomerService> customerServices;

    @OneToMany(mappedBy = "service")
    private List<InvoiceService> invoiceServices;

}
