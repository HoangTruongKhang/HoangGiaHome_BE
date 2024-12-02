package com.utc.HoangGiaHome.repository;

import com.utc.HoangGiaHome.entity.InvoiceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IInvoiceServiceRepository extends JpaRepository<InvoiceService, Integer>, JpaSpecificationExecutor<InvoiceService> {
    InvoiceService findById(int invoiceService_id);
}
