package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.form.BranchFilterForm;

import java.util.List;

public interface IBranchService {
    List<Branch> getAllBranchs(BranchFilterForm form);
    Branch getBranchById(int branch_id);
}
