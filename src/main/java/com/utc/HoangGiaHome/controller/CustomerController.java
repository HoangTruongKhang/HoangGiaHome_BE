package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.CustomerDTO;
import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.form.CustomerFilterForm;
import com.utc.HoangGiaHome.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<CustomerDTO> getAllCustomers(Pageable pageable, CustomerFilterForm form){
        Page<Customer> customerPage = customerService.getAllCustomers(pageable, form);
        List<Customer> customers = customerPage.getContent();
        List<CustomerDTO> customerDTOS = customers.stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(customerDTOS, pageable, customerPage.getTotalElements());
    }

    @GetMapping("{customer_id}")
    public CustomerDTO getCustomerById(@PathVariable int customer_id){
        Customer customer = customerService.getCustomerById(customer_id);
        return  modelMapper.map(customer, CustomerDTO.class);
    }
}
