package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Account;
import com.utc.HoangGiaHome.form.AccountFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<Account> getAllAccounts(Pageable pageable, AccountFilterForm form);
    Account getAccountById(int account_id);
}
