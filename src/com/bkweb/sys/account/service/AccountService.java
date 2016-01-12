package com.bkweb.sys.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.account.dao.AccountDao;
import com.bkweb.sys.account.entity.Account;

@Service
@Transactional(readOnly = true)
public class AccountService extends CrudService<AccountDao, Account> {

}
