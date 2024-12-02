package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.entity.Room;
import com.utc.HoangGiaHome.entity.enums.ContractDuration;
import com.utc.HoangGiaHome.entity.enums.ContractStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDTO {
    private int contract_id;
    private String contract_name;
    private ContractDuration contractDuration;
    private Date start_date;
    private Date end_date;
    private String rent_price;
    private String room_deposit;
    private ContractStatus contractStatus;
    private String note;
    private Date createDate;
    private String  customerFull_name;
    private String  roomRoom_name;
}
