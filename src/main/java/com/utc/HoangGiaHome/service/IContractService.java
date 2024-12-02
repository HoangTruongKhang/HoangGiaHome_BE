package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.form.ContractFilterForm;

import java.util.List;

public interface IContractService {
    List<Contract> getAllContracts(ContractFilterForm form);
    Contract getContractById(int contract_id);
}
