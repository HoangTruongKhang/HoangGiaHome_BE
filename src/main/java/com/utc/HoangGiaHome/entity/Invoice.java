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
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoice_id;

    @Column(name = "invoice_name", length = 100, nullable = false)
    private String invoiceName;

    @Column(name = "old_electric_number", nullable = true)
    private Integer  oldElectricNumber;

    @Column(name = "new_electric_number", nullable = true)
    private Integer newElectricNumber;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_price", length = 50, nullable = false)
    private String unitPrice;

    @Column(name = "total_price", length = 50, nullable = false)
    private String totalPrice;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "note", length = 255)
    private String note;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room;

    @OneToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceService> invoiceServices;

}
