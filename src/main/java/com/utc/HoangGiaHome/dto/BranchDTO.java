package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Account;
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
public class BranchDTO {
    private int branch_id;
    private String branch_name;
    private String address;
    private Date create_at;
    private List<AccountDTO> accountsUsername;

}
