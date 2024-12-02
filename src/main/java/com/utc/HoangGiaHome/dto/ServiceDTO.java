package com.utc.HoangGiaHome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private int service_id;
    private String serviceName;
    private String price;
    private int quantity;
    private String unit;
    private Date createDate;
}
