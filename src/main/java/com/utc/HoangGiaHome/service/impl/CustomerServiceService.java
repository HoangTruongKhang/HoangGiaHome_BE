package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.entity.CustomerService;
import com.utc.HoangGiaHome.form.CustomerServiceFilterForm;
import com.utc.HoangGiaHome.repository.ICustomerServiceRepository;
import com.utc.HoangGiaHome.service.ICustomerServiceService;
import com.utc.HoangGiaHome.specification.ContractSpecification;
import com.utc.HoangGiaHome.specification.CustomerServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceService implements ICustomerServiceService {
    @Autowired
    private ICustomerServiceRepository customerServiceRepository;
    @Override
    public List<CustomerService> getAllCustomerServices(CustomerServiceFilterForm form) {
        Specification<CustomerService> where = CustomerServiceSpecification.buildWhere(form);
        return customerServiceRepository.findAll(where);
    }

    @Override
    public CustomerService getCustomerServiceById(int customerService_id) {
        return customerServiceRepository.findById(customerService_id);
    }
}
