package com.bkweb.sys.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.common.utils.StringUtils;
import com.bkweb.sys.account.dao.AccountDao;
import com.bkweb.sys.account.entity.Account;

@Service
@Transactional(readOnly = true)
public class AccountService extends CrudService<AccountDao, Account> {

	public boolean checkRegister(Account account) {
		if (StringUtils.isEmpty(account.getUsername()) || StringUtils.isEmpty(account.getPassword())) {
			return false;
		}
		List<Account> list = dao.findList(new Account(account.getUsername(), null), false);
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

}
