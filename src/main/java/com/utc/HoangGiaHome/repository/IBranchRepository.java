package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IBranchRepository extends JpaRepository<Branch, Integer>, JpaSpecificationExecutor<Branch> {
    Branch findById(int branch_id);
}
