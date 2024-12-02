package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IContractRepository extends JpaRepository<Contract, Integer>, JpaSpecificationExecutor<Contract> {
    Contract findById(int contract_id);
}
