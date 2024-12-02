package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.AccountDTO;
import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.form.AccountFilterForm;
import com.utc.HoangGiaHome.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<AccountDTO> getAllAccounts(Pageable pageable, AccountFilterForm form){
        Page<Account> accountPage = accountService.getAllAccounts(pageable, form);
        List<Account> accounts = accountPage.getContent();
        List<AccountDTO> accountDTOS = accounts.stream().map(account -> modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(accountDTOS, pageable, accountPage.getTotalElements());
    }

    @GetMapping("{account_id}")
    public AccountDTO getAccountById(@PathVariable int account_id){
        Account account = accountService.getAccountById(account_id);
        return modelMapper.map (account, AccountDTO.class );
    }

}
