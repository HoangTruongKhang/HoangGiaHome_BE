package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Invoice;
import com.utc.HoangGiaHome.form.InvoiceFilterForm;
import com.utc.HoangGiaHome.repository.IInvoiceRepository;
import com.utc.HoangGiaHome.service.IInvoiceService;
import com.utc.HoangGiaHome.specification.InvoiceSpecification;
import com.utc.HoangGiaHome.specification.ServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository iInvoiceRepository;
    @Override
    public Page<Invoice> getAllInvoices(Pageable pageable, InvoiceFilterForm form) {
        Specification<Invoice> where = InvoiceSpecification.buildWhere(form);
        return iInvoiceRepository.findAll(where,pageable);
    }

    @Override
    public Invoice getInvoiceById(int invoice_id) {
        return iInvoiceRepository.findById(invoice_id);
    }
}
