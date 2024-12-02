package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceDTO {
    private int customerService_id;
    private String  customerFull_name;
    private String  serviceServiceName;
    private Date registerDate;
}
