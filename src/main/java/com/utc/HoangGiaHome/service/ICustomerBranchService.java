package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.CustomerBranch;
import com.utc.HoangGiaHome.form.CustomerBranchFilterForm;


import java.util.List;

public interface ICustomerBranchService {
    List<CustomerBranch> getAllCustomerBranch(CustomerBranchFilterForm form);
    CustomerBranch getCustomerBranchById(int customerBranch_id);
}
