package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.entity.InvoiceService;
import com.utc.HoangGiaHome.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    private int invoice_id;
    private String invoiceName;
    private int oldElectricNumber;
    private int newElectricNumber;
    private int quantity;
    private String unitPrice;
    private String totalPrice;
    private Date createDate;
    private String note;
    private String customerFull_name;
    private String roomRoom_name;
    private String branchBranch_name;
}
