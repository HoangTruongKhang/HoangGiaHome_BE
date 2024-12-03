package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.CustomerRoom;
import com.utc.HoangGiaHome.form.CustomerRoomFilterForm;

import java.util.List;

public interface ICustomerRoomService {
    List<CustomerRoom> getAllCustomerRoom(CustomerRoomFilterForm form);
    CustomerRoom getCustomerRoomById(int customerRoom_id);
}
