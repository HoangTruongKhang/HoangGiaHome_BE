package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Invoice;
import com.utc.HoangGiaHome.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceServiceDTO {
    private int invoiceService_id;
    private String invoiceInvoiceName;
    private String serviceServiceName;
}
