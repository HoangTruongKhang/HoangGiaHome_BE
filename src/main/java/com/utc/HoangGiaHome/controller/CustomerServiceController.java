package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.CustomerServiceDTO;
import com.utc.HoangGiaHome.entity.CustomerService;
import com.utc.HoangGiaHome.form.CustomerServiceFilterForm;
import com.utc.HoangGiaHome.service.ICustomerServiceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customerservices")
public class CustomerServiceController {
    @Autowired
    private ICustomerServiceService customerServiceService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CustomerServiceDTO> getAllCustomerServices(CustomerServiceFilterForm form){
        List<CustomerService> customerServices = customerServiceService.getAllCustomerServices(form);
        return modelMapper.map(customerServices, new TypeToken<List<CustomerServiceDTO>>(){}.getType());
    }

    @GetMapping("{customerService_id}")
    public CustomerServiceDTO getCustomerServiceById(@PathVariable int customerService_id){
        CustomerService customerService = customerServiceService.getCustomerServiceById(customerService_id);
        return modelMapper.map(customerService, CustomerServiceDTO.class);
    }


}
