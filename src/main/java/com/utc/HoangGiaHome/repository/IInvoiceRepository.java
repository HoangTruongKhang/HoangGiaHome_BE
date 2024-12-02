package com.utc.HoangGiaHome.repository;

import com.utc.HoangGiaHome.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer>, JpaSpecificationExecutor<Invoice> {
    Invoice findById(int invoice_id);
}
