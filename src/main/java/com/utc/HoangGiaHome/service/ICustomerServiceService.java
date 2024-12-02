package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.CustomerService;
import com.utc.HoangGiaHome.form.CustomerServiceFilterForm;

import java.util.List;

public interface ICustomerServiceService {
    List<CustomerService> getAllCustomerServices(CustomerServiceFilterForm form);
    CustomerService getCustomerServiceById(int customerService_id);
}
