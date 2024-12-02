package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.BranchDTO;
import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.form.BranchFilterForm;
import com.utc.HoangGiaHome.service.IBranchService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branch")
public class BranchController {
    @Autowired
    private IBranchService branchService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<BranchDTO> getAllBranchs(BranchFilterForm form){
        List<Branch> branches = branchService.getAllBranchs(form);
        return modelMapper.map(branches, new TypeToken<List<BranchDTO>>(){}.getType());
    }

    @GetMapping("{branch_id}")
    public BranchDTO getBranchById(@PathVariable int branch_id){
        Branch branch = branchService.getBranchById(branch_id);
        return modelMapper.map(branch, BranchDTO.class);
    }
}
