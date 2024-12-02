package com.utc.HoangGiaHome.dto;

import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.entity.enums.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String room_name;
    private String branchBranch_name;
    private RoomStatus roomStatus;
    private int price;
    private int area;
    private List<CustomerDTO> customers;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CustomerDTO{
        private String full_name;
    }
}
