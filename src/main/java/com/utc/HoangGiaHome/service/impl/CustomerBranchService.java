package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.CustomerBranch;
import com.utc.HoangGiaHome.form.CustomerBranchFilterForm;
import com.utc.HoangGiaHome.repository.ICustomerBranchRepository;
import com.utc.HoangGiaHome.service.ICustomerBranchService;
import com.utc.HoangGiaHome.specification.CustomerBranchSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class CustomerBranchService implements ICustomerBranchService {
    @Autowired
    private ICustomerBranchRepository customerBranchRepository;
    @Override
    public List<CustomerBranch> getAllCustomerBranch(CustomerBranchFilterForm form) {
        Specification<CustomerBranch> where = CustomerBranchSpecification.buildWhere(form);
        return customerBranchRepository.findAll(where);
    }


    @Override
    public CustomerBranch getCustomerBranchById(int customerBranch_id) {
        return customerBranchRepository.findById(customerBranch_id);
    }
}
