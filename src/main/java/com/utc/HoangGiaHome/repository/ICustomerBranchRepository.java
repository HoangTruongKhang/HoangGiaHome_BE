package com.utc.HoangGiaHome.repository;

import com.utc.HoangGiaHome.entity.CustomerBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICustomerBranchRepository extends JpaRepository<CustomerBranch, Integer>, JpaSpecificationExecutor<CustomerBranch> {
    CustomerBranch findById(int customerBranch_id);
}
