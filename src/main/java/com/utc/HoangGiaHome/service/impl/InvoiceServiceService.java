package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.CustomerService;
import com.utc.HoangGiaHome.entity.InvoiceService;
import com.utc.HoangGiaHome.form.InvoiceServiceFilterForm;
import com.utc.HoangGiaHome.repository.IInvoiceServiceRepository;
import com.utc.HoangGiaHome.service.IInvoiceService;
import com.utc.HoangGiaHome.service.IInvoiceServiceService;
import com.utc.HoangGiaHome.specification.CustomerServiceSpecification;
import com.utc.HoangGiaHome.specification.InvoiceServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceService implements IInvoiceServiceService {
    @Autowired
    private IInvoiceServiceRepository invoiceServiceRepository;
    @Override
    public List<InvoiceService> getAllInvoiceServices(InvoiceServiceFilterForm form) {
        Specification<InvoiceService> where = InvoiceServiceSpecification.buildWhere(form);
        return invoiceServiceRepository.findAll(where);
    }

    @Override
    public InvoiceService getInvoiceServiceById(int invoiceService_id) {
        return invoiceServiceRepository.findById(invoiceService_id);
    }
}
