package com.bkweb.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.authority.dao.CAccountRoleDao;
import com.bkweb.sys.authority.entity.AccountRole;

@Service
public class CAccountRoleService extends CrudService<CAccountRoleDao, AccountRole> {

}
