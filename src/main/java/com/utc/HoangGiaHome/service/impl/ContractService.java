package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.form.ContractFilterForm;
import com.utc.HoangGiaHome.repository.IContractRepository;
import com.utc.HoangGiaHome.service.IContractService;
import com.utc.HoangGiaHome.specification.BranchSpecification;
import com.utc.HoangGiaHome.specification.ContractSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public List<Contract> getAllContracts(ContractFilterForm form) {
        Specification<Contract> where = ContractSpecification.buildWhere(form);
        return contractRepository.findAll(where);
    }

    @Override
    public Contract getContractById(int contract_id) {
        return contractRepository.findById(contract_id);
    }
}
