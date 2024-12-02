package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.ContractDTO;
import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.form.ContractFilterForm;
import com.utc.HoangGiaHome.service.IContractService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<ContractDTO> getAllContracts(ContractFilterForm form){
        List<Contract> contracts = contractService.getAllContracts(form);
        return modelMapper.map(contracts, new TypeToken<List<ContractDTO>>(){}.getType());
    }

    @GetMapping("{contract_id}")
    public ContractDTO getContractById(@PathVariable int contract_id){
        Contract contract = contractService.getContractById(contract_id);
        return modelMapper.map(contract, ContractDTO.class);
    }
}
