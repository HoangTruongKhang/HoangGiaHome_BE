package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.InvoiceService;
import com.utc.HoangGiaHome.form.InvoiceServiceFilterForm;

import java.util.List;

public interface IInvoiceServiceService {
    List<InvoiceService> getAllInvoiceServices(InvoiceServiceFilterForm form);
    InvoiceService getInvoiceServiceById(int InvoiceService_id);
}
