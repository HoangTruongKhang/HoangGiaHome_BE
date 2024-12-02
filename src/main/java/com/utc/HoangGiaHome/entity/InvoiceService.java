package com.utc.HoangGiaHome.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InvoiceService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceService_id;

    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id", nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false)
    private Service service;
}

