package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.entity.Room;
import com.utc.HoangGiaHome.form.AccountFilterForm;
import com.utc.HoangGiaHome.repository.IAccountRepository;
import com.utc.HoangGiaHome.service.IAccountService;
import com.utc.HoangGiaHome.specification.AccountSpecification;
import com.utc.HoangGiaHome.specification.RoomSpeciification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service

public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm form) {
        Specification<Account> where = AccountSpecification.buildWhere(form);
        return accountRepository.findAll(where,pageable);
    }

    @Override
    public Account getAccountById(int account_id) {
        return accountRepository.findById(account_id);
    }
}
