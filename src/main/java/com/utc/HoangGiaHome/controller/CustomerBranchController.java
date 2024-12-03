package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.CustomerBranchDTO;
import com.utc.HoangGiaHome.entity.CustomerBranch;
import com.utc.HoangGiaHome.form.CustomerBranchFilterForm;
import com.utc.HoangGiaHome.service.ICustomerBranchService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customerbranchs")
public class CustomerBranchController {
    @Autowired
    private ICustomerBranchService customerBranchService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CustomerBranchDTO> getAllCustomerBranch(CustomerBranchFilterForm form){
        List<CustomerBranch> customerBranches = customerBranchService.getAllCustomerBranch(form);
        return modelMapper.map(customerBranches, new TypeToken<List<CustomerBranchDTO>>(){}.getType());
    }

    @GetMapping("{customerBranch_id}")
    public CustomerBranchDTO getCustomerBranchById(@PathVariable int customerBranch_id){
        CustomerBranch customerBranch = customerBranchService.getCustomerBranchById(customerBranch_id);
        return modelMapper.map(customerBranch, CustomerBranchDTO.class);
    }
}
