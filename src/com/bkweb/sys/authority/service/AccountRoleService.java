package com.bkweb.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.authority.dao.AccountRoleDao;
import com.bkweb.sys.authority.entity.AccountRole;

@Service
public class AccountRoleService extends CrudService<AccountRoleDao, AccountRole> {

}
