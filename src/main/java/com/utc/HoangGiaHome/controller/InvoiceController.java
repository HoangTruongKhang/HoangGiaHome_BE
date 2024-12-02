package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.InvoiceDTO;
import com.utc.HoangGiaHome.entity.Invoice;
import com.utc.HoangGiaHome.form.InvoiceFilterForm;
import com.utc.HoangGiaHome.service.IInvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {
    @Autowired
    private IInvoiceService iInvoiceService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<InvoiceDTO> getAllInvoices(Pageable pageable, InvoiceFilterForm form){
        Page<Invoice> invoicePage = iInvoiceService.getAllInvoices(pageable,form );
        List<Invoice> invoices = invoicePage.getContent();
        List<InvoiceDTO> invoiceDTOS = invoices.stream().map(invoice -> modelMapper.map(invoice, InvoiceDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(invoiceDTOS, pageable, invoicePage.getTotalElements());
    }

    @GetMapping("{invoice_id}")
    public InvoiceDTO getInvoiceById(@PathVariable int invoice_id){
        Invoice invoice = iInvoiceService.getInvoiceById(invoice_id);
        return modelMapper.map(invoice, InvoiceDTO.class);
    }
}
