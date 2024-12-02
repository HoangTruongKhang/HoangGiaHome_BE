package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.entity.enums.AccountRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private int account_id;
    private String username;
    private String first_name;
    private String last_name;
    private String phone_number;
    private AccountRole role;
    private Date create_at;
    private String branchBranch_name;
}
