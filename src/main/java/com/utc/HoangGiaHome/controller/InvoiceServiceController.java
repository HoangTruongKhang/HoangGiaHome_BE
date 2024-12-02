package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.InvoiceServiceDTO;
import com.utc.HoangGiaHome.entity.InvoiceService;
import com.utc.HoangGiaHome.form.InvoiceServiceFilterForm;
import com.utc.HoangGiaHome.service.IInvoiceServiceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoiceServices")
public class InvoiceServiceController {
    @Autowired
    private IInvoiceServiceService iInvoiceServiceService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<InvoiceServiceDTO> getAllInvoiceServices(InvoiceServiceFilterForm form){
        List<InvoiceService> invoiceServices = iInvoiceServiceService.getAllInvoiceServices(form);
        return modelMapper.map(invoiceServices, new TypeToken<List<InvoiceServiceDTO>>(){}.getType());
    }

    @GetMapping("{invoiceService_id}")
    public InvoiceServiceDTO getInvoiceServiceById(@PathVariable int invoiceService_id){
        InvoiceService invoiceService = iInvoiceServiceService.getInvoiceServiceById(invoiceService_id);
        return modelMapper.map(invoiceService, InvoiceServiceDTO.class);
    }
}
