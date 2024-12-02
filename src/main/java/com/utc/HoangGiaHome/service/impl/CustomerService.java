package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.form.CustomerFilterForm;
import com.utc.HoangGiaHome.repository.ICustomerRepository;
import com.utc.HoangGiaHome.service.ICustomerService;
import com.utc.HoangGiaHome.specification.AccountSpecification;
import com.utc.HoangGiaHome.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<Customer> getAllCustomers(Pageable pageable, CustomerFilterForm form) {
        Specification<Customer> where = CustomerSpecification.buildWhere(form);
        return customerRepository.findAll(where, pageable);
    }

    @Override
    public Customer getCustomerById(int customer_id) {
        return customerRepository.findById(customer_id);
    }
}
