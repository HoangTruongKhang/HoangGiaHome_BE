package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBranchDTO {
    private int customerBranch_id;
    private String customerFull_name;
    private String  branchBranch_name;
    private Date registerDate;
}
