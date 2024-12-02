package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Invoice;
import com.utc.HoangGiaHome.form.InvoiceFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInvoiceService {
    Page<Invoice> getAllInvoices(Pageable pageable, InvoiceFilterForm form);
    Invoice getInvoiceById(int invoice_id);
}
