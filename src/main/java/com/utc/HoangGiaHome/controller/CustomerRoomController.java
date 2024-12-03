package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.CustomerBranchDTO;
import com.utc.HoangGiaHome.dto.CustomerRoomDTO;
import com.utc.HoangGiaHome.entity.CustomerBranch;
import com.utc.HoangGiaHome.entity.CustomerRoom;
import com.utc.HoangGiaHome.form.CustomerBranchFilterForm;
import com.utc.HoangGiaHome.form.CustomerRoomFilterForm;
import com.utc.HoangGiaHome.service.ICustomerBranchService;
import com.utc.HoangGiaHome.service.ICustomerRoomService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customerroom")
public class CustomerRoomController {
    @Autowired
    private ICustomerRoomService customerRoomService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CustomerRoomDTO> getAllCustomerRoom(CustomerRoomFilterForm form){
        List<CustomerRoom> customerRooms = customerRoomService.getAllCustomerRoom(form);
        return modelMapper.map(customerRooms, new TypeToken<List<CustomerRoomDTO>>(){}.getType());
    }

    @GetMapping("{customerRoom_id}")
    public CustomerRoomDTO getCustomerRoomById(@PathVariable int customerRoom_id){
        CustomerRoom customerRoom = customerRoomService.getCustomerRoomById(customerRoom_id);
        return modelMapper.map(customerRoom, CustomerRoomDTO.class);
    }
}
