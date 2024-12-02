package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Customer;
import com.utc.HoangGiaHome.form.CustomerFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> getAllCustomers(Pageable pageable, CustomerFilterForm form);
    Customer getCustomerById(int customer_id);
}
