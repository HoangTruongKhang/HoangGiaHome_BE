package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.CustomerBranch;
import com.utc.HoangGiaHome.entity.CustomerRoom;
import com.utc.HoangGiaHome.form.CustomerRoomFilterForm;
import com.utc.HoangGiaHome.repository.ICustomerBranchRepository;
import com.utc.HoangGiaHome.repository.ICustomerRoomRepository;
import com.utc.HoangGiaHome.service.ICustomerRoomService;
import com.utc.HoangGiaHome.specification.CustomerBranchSpecification;
import com.utc.HoangGiaHome.specification.CustomerRoomSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CustomerRoomService implements ICustomerRoomService {
    @Autowired
    private ICustomerRoomRepository customerRoomRepository;
    @Override
    public List<CustomerRoom> getAllCustomerRoom(CustomerRoomFilterForm form) {
        Specification<CustomerRoom> where = CustomerRoomSpecification.buildWhere(form);
        return customerRoomRepository.findAll(where);
    }

    @Override
    public CustomerRoom getCustomerRoomById(int customerRoom_id) {
        return customerRoomRepository.findById(customerRoom_id);
    }
}
