package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String full_name;
    private String cmnd;
    private String phone_number;
    private String email;
    private Date birth_date;
    private String address;
    private String branchBranch_name;
    private String roomRoom_name;
}
