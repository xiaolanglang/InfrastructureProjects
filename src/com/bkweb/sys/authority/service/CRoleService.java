package com.bkweb.sys.authority.service;

import org.springframework.stereotype.Service;

import com.bkweb.common.service.impl.CrudService;
import com.bkweb.sys.authority.dao.CRoleDao;
import com.bkweb.sys.authority.entity.Role;

@Service
public class CRoleService extends CrudService<CRoleDao, Role> {

}
