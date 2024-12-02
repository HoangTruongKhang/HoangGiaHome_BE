package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.form.BranchFilterForm;
import com.utc.HoangGiaHome.repository.IBranchRepository;
import com.utc.HoangGiaHome.service.IBranchService;
import com.utc.HoangGiaHome.specification.BranchSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchService implements IBranchService {
    @Autowired
    private IBranchRepository branchRepository;
    @Override
    public List<Branch> getAllBranchs(BranchFilterForm form) {
        Specification<Branch> where = BranchSpecification.buildWhere(form);
        return branchRepository.findAll(where);
    }

    @Override
    public Branch getBranchById(int branch_id) {
        return branchRepository.findById(branch_id);
    }
}
