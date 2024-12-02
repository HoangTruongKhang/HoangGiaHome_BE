package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICustomerServiceRepository extends JpaRepository<CustomerService, Integer>, JpaSpecificationExecutor<CustomerService> {
    CustomerService findById(int customerService_id);
}
